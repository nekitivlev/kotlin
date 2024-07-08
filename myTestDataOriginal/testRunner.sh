#!/bin/bash

#
# Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
# Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
#

# Change directory to where the test files are located
cd when/

# Loop through each test file and run hyperfine
for test_file in test*.kt; do
    echo "Benchmarking $test_file..."
    hyperfine "../../dist/kotlinc/bin/kotlinc $test_file"
done
