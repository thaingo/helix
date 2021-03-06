/**
 * Copyright (C) 2012 LinkedIn Inc <opensource@linkedin.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.linkedin.helix.controller.pipeline;

import com.linkedin.helix.controller.stages.ClusterEvent;

/**
 * Logically independent unit in processing callbacks for cluster changes  
 *
 */
public interface Stage
{

  /**
   * Initialize a stage
   * @param context
   */
  void init(StageContext context);

  /**
   * Called before process() on each callback
   */
  void preProcess();

  /**
   * Actual callback processing logic
   * @param event
   * @throws Exception
   */
  public void process(ClusterEvent event) throws Exception;

  /**
   * Called after process() on each callback
   */
  void postProcess();

  /**
   * Destruct a stage
   */
  void release();

  /**
   * Get the name of the stage
   * @return
   */
  public String getStageName();
}
