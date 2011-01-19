/*
 * Copyright (C) 2011 Matthias Weßendorf.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.wessendorf.enterprise.service;

import java.util.List;

import net.wessendorf.enterprise.beans.Person;

public interface PersonService
{
  Person savePerson(Person person);
  void removePerson(Person person);
  Person updatePerson(Person person);
  Person findPersonById(String id);
  List<Person> findAllPersons();
  List<Person> findPersonsByLastName(String lastName);

}
