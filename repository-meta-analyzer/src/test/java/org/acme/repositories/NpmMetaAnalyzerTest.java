/*
 * This file is part of Dependency-Track.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 * Copyright (c) Steve Springett. All Rights Reserved.
 */
package org.acme.repositories;

import com.github.packageurl.PackageURL;
import org.acme.model.Component;
import org.acme.model.MetaModel;
import org.acme.model.RepositoryType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NpmMetaAnalyzerTest {

    @Test
    void testAnalyzer() throws Exception {
        Component component = new Component();
        component.setPurl(new PackageURL("pkg:npm/qunit@2.7.0"));

        NpmMetaAnalyzer analyzer = new NpmMetaAnalyzer();
        Assertions.assertEquals("NpmMetaAnalyzer", analyzer.getName());
        Assertions.assertTrue(analyzer.isApplicable(component));
        Assertions.assertEquals(RepositoryType.NPM, analyzer.supportedRepositoryType());
        MetaModel metaModel = analyzer.analyze(component);
        Assertions.assertNotNull(metaModel.getLatestVersion());
        //Assert.assertNotNull(metaModel.getPublishedTimestamp()); // todo: not yet supported
    }
}