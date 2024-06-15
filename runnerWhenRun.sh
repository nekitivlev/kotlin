#!/bin/sh

# Set the directory containing your Kotlin files
DIRECTORY="runExamplesWhen"

# Initialize total time and count for compile time
total_compile_time=0
compile_count=0

# Initialize total time and count for run time
total_run_time=0
run_count=0

# Loop through each .kt file in the directory
for file in "$DIRECTORY"/*.kt
do
    # Check if there are any .kt files
    if [ ! -e "$file" ]; then
        echo "No .kt files found in the directory."
        exit 1
    fi

    echo "Compiling $file"

    # Extract the filename without extension
    filename=$(basename -- "$file")
    filename="${filename%.*}"

    # Run hyperfine benchmark and export results to a JSON file
    hyperfine -w 5 -r 10 --export-json "$filename-compile.json" "./dist/kotlinc/bin/kotlinc $file -include-runtime -d $filename.jar"
    
    # Check if hyperfine executed successfully
    if [ $? -ne 0 ]; then
        echo "Error: hyperfine failed for $file"
        continue
    fi

    # Extract the mean compile time from the JSON file
    compile_time=$(jq '.results[0].mean' "$filename-compile.json")

    # Check if jq executed successfully
    if [ $? -ne 0 ]; then
        echo "Error: jq failed for $filename-compile.json"
        continue
    fi

    # Add the compile time to the total compile time
    total_compile_time=$(echo "scale=5; $total_compile_time + $compile_time" | bc)
    compile_count=$((compile_count + 1))

    # Run the compiled JAR file and benchmark the running time
    hyperfine -w 5 -r 10 --export-json "$filename-run.json" "java -jar $filename.jar"

    # Check if hyperfine executed successfully
    if [ $? -ne 0 ]; then
        echo "Error: hyperfine failed for running $filename.jar"
        continue
    fi

    # Extract the mean run time from the JSON file
    run_time=$(jq '.results[0].mean' "$filename-run.json")

    # Check if jq executed successfully
    if [ $? -ne 0 ]; then
        echo "Error: jq failed for $filename-run.json"
        continue
    fi

    # Add the run time to the total run time
    total_run_time=$(echo "scale=5; $total_run_time + $run_time" | bc)
    run_count=$((run_count + 1))
done

# Calculate the average compile time
if [ $compile_count -ne 0 ]; then
    average_compile_time=$(echo "scale=5; $total_compile_time / $compile_count" | bc)
    echo "Average compile time is $average_compile_time seconds"
else
    echo "No files compiled."
fi

# Calculate the average run time
if [ $run_count -ne 0 ]; then
    average_run_time=$(echo "scale=5; $total_run_time / $run_count" | bc)
    echo "Average run time is $average_run_time seconds"
else
    echo "No files run."
fi

# Clean up: Delete all created .json and .class files
rm -f *.json
rm -f *.class


