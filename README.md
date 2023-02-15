# Dependency Injection in Play

This is a sample application that shows how to use dependency injection in Play.
Dependency injection allows you to bind different implementations to a component.
This is very useful for testing, because you can instantiate components using mock implementations.

## Steps to introduce dependency injection

1. Add the dependency injection library to your build.sbt file
    ```scala 
    libraryDependencies += guice
    ```

2. Define a trait for the component you want to inject and define the default implementation with the `@ImplementedBy` annotation.
    ```scala
   @ImplementedBy(classOf[ServiceImplProduction])
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

5. Create/Extend a module that binds the trait to the production implementation
    ```scala
   class ProductionModule extends AbstractModule {
     override def configure(): Unit = bind(classOf[Service]).to(classOf[ServiceImplProduction])
   }
    ```

6. Create a module that binds the trait to the mock implementation
    ```scala
   class MockModule extends AbstractModule {
     override def configure(): Unit = bind(classOf[Service]).to(classOf[ServiceImplMock])
   }
    ```

7. Create a Unit-test that requests the `/` endpoint

   If you send a request to the `/` endpoint, the production implementation is the default.
   ```scala
   "return the production message when the endpoint is requested" in {
     val app = new GuiceApplicationBuilder().build()

     val response: String = route(app, FakeRequest(GET, "/demo")).map(contentAsString(_)).getOrElse("")
     response must include("Production implementation")
   }
   ```   

   If you send a request to the `/` endpoint and override the binding with your MockModule, the mock implementation is used.
   ```scala
   "return the mock message when the endpoint is requested with overridden bindings" in {
     val app = new GuiceApplicationBuilder().overrides(new MockModule).build()

     val response: String = route(app, FakeRequest(GET, "/demo")).map(contentAsString(_)).getOrElse("")
     response must include("Mock implementation")
   }
   ```



## Further reading
- https://www.playframework.com/documentation/2.8.x/ScalaTestingWithGuice
- https://www.playframework.com/documentation/2.8.x/ScalaDependencyInjection