# maven-multi-module-test-dependencies
A demonstration of the mechanism, which maven uses to check dependencies. And how to overcome a problem, which may occur in case of multi module test jar dependency due to this mechanism.

## Inter-Module Test Dependencies and Skipping Test Compilation in Maven
While creating a multi module java project using maven as the package manager, we often need to add dependencies in a module, on the jars from other modules, for test scope. This can be a problem when you do not want to compile your test classes for any of the modules.

### Why skipping test class compilation?
Although in ideal scenario we should not skip compiling test classes, but it becomes handy when you have done some framework level changes (Example: changed name of some classes), and you have lots of test classes impacted due to these changes. Now you may want to do some sanity testing before fixing your unit test classes. Here you need some kind of dependency management mechanism, where you can build your project without compiling the test classes.

### Dependency lookup mechanism of Maven:
Suppose you have some dependencies for test classes of one module, on test classes of another module and you have added the dependency in your dependent(say dependent-module1) modules' pom.xml, this way:
```
<dependencies>
  <dependency>
    <groupId>any.group.id</groupId>
    <artifactId>common-library</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <classifier>tests</classifier>
    <scope>test</scope>
  </dependency>
</dependencies>  
```
Here maven will first check that mentioned dependecies(with test classifier) are avilable or not then it checks the scope. As a result compiling all the modules one-by-one, skipping compilation of the test classes in them will give build failure, when maven will come to compile the module dependent-module1. To overcome this problem we can add the dependencies inside some profile and activate the profile based on some conditions.

In this sample project there are three modules where common-lib module has the coomon test classes used by other two modules. pom.xml of dependent-module1 module has been set up in such a way which will illustrate the above problem in details. Refer to the pom.xml of dependendent-module2 and outer pom.xml file, to see how the problem can be resolved using profile based solution, without changing the build command. 

### How to build different profiles in this project?
Here are the build commands for Profile1(which builds common-lib then dependent-module1):
  * To Compile and Run Tests: mvn clean install -Dtest.dependency1 
  * Do not Compile or Run Tests: mvn clean install -Dtest.dependency1 -Dmaven.test.skip // This will cause build failure
  * Compile but Do not Run Tests: mvn clean install -Dtest.dependency1 -DskipTests
 
Build commands for Profile2(which builds common-lib then dependent-module2):
  * To Compile and Run Tests: mvn clean install -Dtest.dependency2 
  * Do not Compile or Run Tests: mvn clean install -Dtest.dependency2 -Dmaven.test.skip // This will not cause build failure
  * Compile but Do not Run Tests: mvn clean install -Dtest.dependency2 -DskipTests
  
