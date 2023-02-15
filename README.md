# Dependency Injection in Play

This is a sample application that shows how to use dependency injection in Play.
Dependency injection allows you to bind different implementations to a component.
This is very useful for testing, because you can instantiate components using mock implementations.

## Steps to introduce dependency injection

1. Add the dependency injection library to your build.sbt file
    ```scala 
    libraryDependencies += guice
    ```

2. Define a trait for the component you want to inject
    ```scala
    trait Service {
      def externalCall: String
    }
    ```
3. Let the class with your business logic extend from this trait
    ```scala
    class ServiceImplProduction() extends Service {
      override def externalCall: String = "Production implementation"
    }
    ```

4. Let the class with your mocking implementation extend from this trait
    ```scala
    class ServiceImplMock() extends Service {
      override def externalCall: String = "Mock implementation"
    }
    ```

5. Create/Extend a module that binds the trait to the implementation
    ```scala
   class ServiceModule extends Module {
     override def bindings(environment: Environment, configuration: Configuration) =
       Seq(bind[Service].to(classOf[ServiceImplProduction]))
   }
    ```

6. 

## Further reading
- https://www.playframework.com/documentation/2.8.x/ScalaTestingWithGuice
- https://www.playframework.com/documentation/2.8.x/ScalaDependencyInjection