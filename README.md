# spring-dependency-injection-notes
Contains notes covering best practices regarding various ways to inject dependencies. Covers @Qualifier, @Primary, @Controller, and @Profile in depth, as well as the Bean lifecycle and its related interfaces.

# SOLID Principles #

**Single Responsibility Principle:** A class should have one and only one reason to change, meaning that a class should only have one job.

**Open-Closed Principle:** Objects or entities should be open for extension but closed for modification. This means that a class should be extendable without modifying the class itself. In Java, we can create interfaces and abstract classes that are fixed but represent an unbounded group of possible behaviours through concrete implmentations.

**Liskov Substitution Principle:** Every subclass should be substitutible for their superclass.

**Interface Segregation Principle:** Clients should not be forced to depend on methods that they do not use. In Java, this means avoid bloated interfaces. We don't want to force classes to implement methods that aren't used by them (i.e. dummy methods or stubs). Instead, segregate a large interface into mulitple role interfaces with different sets of behaviours. 

**Dependency Inversion Principle:** High level modules should NOT depend on low level modules. Both should depend on abstractions. Abstractions should not depend on details. Details should depend on abstractions. Another way of saying this is avoid tightly coupled code. When one class knows explicitly about the design and implementation of another class, changes to one class raise the risk of breaking the other class. 
