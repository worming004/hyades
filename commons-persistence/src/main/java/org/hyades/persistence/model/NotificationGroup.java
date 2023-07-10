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
package org.hyades.persistence.model;

public enum NotificationGroup {

    // System Groups
    CONFIGURATION,
    DATASOURCE_MIRRORING,
    REPOSITORY,
    INTEGRATION,
    FILE_SYSTEM,
    ANALYZER,

    // Portfolio Groups
    NEW_VULNERABILITY,
    NEW_VULNERABLE_DEPENDENCY,
    //NEW_OUTDATED_COMPONENT,
    //FIXED_VULNERABILITY,
    //FIXED_OUTDATED,
    //GLOBAL_AUDIT_CHANGE,
    PROJECT_AUDIT_CHANGE,
    BOM_CONSUMED,
    BOM_PROCESSED,
    BOM_PROCESSING_FAILED,
    VEX_CONSUMED,
    VEX_PROCESSED,
    POLICY_VIOLATION,
    PROJECT_CREATED,
    PROJECT_VULN_ANALYSIS_COMPLETE
}
