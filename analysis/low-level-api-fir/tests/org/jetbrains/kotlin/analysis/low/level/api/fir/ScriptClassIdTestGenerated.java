/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.low.level.api.fir;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/low-level-api-fir/testdata/classId")
@TestDataPath("$PROJECT_ROOT")
public class ScriptClassIdTestGenerated extends AbstractScriptClassIdTest {
    @Test
    public void testAllFilesPresentInClassId() throws Exception {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/low-level-api-fir/testdata/classId"), Pattern.compile("^(.+)\\.(kts)$"), null, true);
    }

    @Test
    @TestMetadata("classWithMembers.kts")
    public void testClassWithMembers() throws Exception {
        runTest("analysis/low-level-api-fir/testdata/classId/classWithMembers.kts");
    }

    @Test
    @TestMetadata("classWithMembersWithPackage.kts")
    public void testClassWithMembersWithPackage() throws Exception {
        runTest("analysis/low-level-api-fir/testdata/classId/classWithMembersWithPackage.kts");
    }

    @Test
    @TestMetadata("enum.kts")
    public void testEnum() throws Exception {
        runTest("analysis/low-level-api-fir/testdata/classId/enum.kts");
    }

    @Test
    @TestMetadata("enumEntry.kts")
    public void testEnumEntry() throws Exception {
        runTest("analysis/low-level-api-fir/testdata/classId/enumEntry.kts");
    }

    @Test
    @TestMetadata("namelessClasses.kts")
    public void testNamelessClasses() throws Exception {
        runTest("analysis/low-level-api-fir/testdata/classId/namelessClasses.kts");
    }

    @Test
    @TestMetadata("namelessInsideNamelessClasses.kts")
    public void testNamelessInsideNamelessClasses() throws Exception {
        runTest("analysis/low-level-api-fir/testdata/classId/namelessInsideNamelessClasses.kts");
    }
}
