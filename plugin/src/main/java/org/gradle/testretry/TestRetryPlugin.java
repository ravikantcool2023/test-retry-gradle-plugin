/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.testretry;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.tasks.testing.Test;

import javax.inject.Inject;

import static org.gradle.testretry.internal.TestTaskConfigurer.configureTestTask;

public class TestRetryPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        project.getTasks()
            .withType(Test.class)
            .configureEach(task -> configureTestTask(task, getObjectFactory(), getProviderFactory()));
    }

    @Inject
    protected ObjectFactory getObjectFactory() {
        throw new UnsupportedOperationException();
    }

    @Inject
    protected ProviderFactory getProviderFactory() {
        throw new UnsupportedOperationException();
    }

}
