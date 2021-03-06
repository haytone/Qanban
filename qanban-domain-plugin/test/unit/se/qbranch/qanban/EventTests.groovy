/*
 * Copyright 2009 Qbranch AB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package se.qbranch.qanban

import grails.test.*

class EventTests extends GrailsUnitTestCase {
  protected void setUp() {
    super.setUp()
    mockDomain(Event)
  }

  protected void tearDown() {
    super.tearDown()
  }

  void testEquals() {
    def event1 = new Event(domainId:'did')
    event1.save()

    def event2 = Event.findByDomainId('did')

    def event3 = new Event(domainId:'dint')
    event3.save()
    println event1.id
    println event3.id
    assertTrue "Should be equal", event1.equals(event2)   // == uses compareTo instead of equals when the class implements the comparable interface
    assertFalse "Shouldn't be equal", event2.equals(event3)
    
  }
}
