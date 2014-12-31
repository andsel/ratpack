/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ratpack.handling.internal;

import ratpack.func.NoArgAction;
import ratpack.handling.ByMethodSpec;

import java.util.Map;

public class DefaultByMethodSpec implements ByMethodSpec {

  private final Map<String, NoArgAction> handlers;

  public DefaultByMethodSpec(Map<String, NoArgAction> handlers) {
    this.handlers = handlers;
  }

  public ByMethodSpec get(NoArgAction handler) {
    return named("GET", handler);
  }

  public ByMethodSpec post(NoArgAction handler) {
    return named("POST", handler);
  }

  public ByMethodSpec put(NoArgAction handler) {
    return named("PUT", handler);
  }

  public ByMethodSpec patch(NoArgAction handler) {
    return named("PATCH", handler);
  }

  public ByMethodSpec delete(NoArgAction handler) {
    return named("DELETE", handler);
  }

  public ByMethodSpec named(String methodName, NoArgAction handler) {
    handlers.put(methodName.toUpperCase(), handler);
    return this;
  }

}
