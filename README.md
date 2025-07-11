# Solid and clean code in Java
In this repository, I will be documenting the concepts, principles and best practices of Clean code y the Solid principles in Java. Mi goal is have a resource that I can return when need to review or consult especific examples. here, you'll find examples organized by topics, along with brief explications for each. 

## principles of clean code
Clean code is easy of read, understand and modify. it's achieved through a clear structured, meaningful names, small funtions and **Single Responsability per Component**. its quality is maintained and improved through continues and safe refactoring, supported by a good unit test coverage that allows does changes to be made with confidence.
### Names that reveal intention

#### Names should be clear and reflect our intention.

❌ **Bad example**  
```java
int d;
int m;
int m;
```

✅ **Good example** 
```java
int dayOfBirth;
int monthOfBirth;
int yearOfBirth;
```

Although in loops it is entirely posible and reasonable create short names for variables.
```java
for(int i=0;i< nuumberOfRequests){
    processsRequest(request.get(i);
}
```

#### Avoid misinformation

Avoid calling classes with names that are difficult to look up and name.
```java
public class ServiceForEfficientUpdateMysqlDatabase{
```
```java
public class ServiceForEfficientBackupMysqlDatabase{
```

This is not actually a list, so adding the word List can be confusing.
```java
Map<Integer, String> employeeList;
```

These two classes do not have a clear difference, therefore they can cause confusing.
```java
public class ProductData{}
public class ProductInfo{}
```

#### Use pronounceable names

❌ **Bad example** 
```java
String nn;
String ln;
```
✅ **Good example**
```java
String name;
String lastname;
```
- Avoid using abbreviations 
   
   ❌ **Bad example** 
  ```java
  String lstUsedName;
  ```
  ✅ **Good example**
  ```java
  String leastUsedName;
  ```
- It's much better to choose a very large name than one that doesn't convey it's meaning clearly.

#### Names of classes and methods
- The classes names must be **a name or set of names,** should not be verbs. 
- The methods must be **verbs,** indicating an action.
- Do not name a class ```CreateEmployee{``` or a method ```EmployeeName() ```, for example.

✅ **Good example**
```java
public class DateParser{
    public Date parse(String date);
}
```


#### Add context that provides meaning
```
firstName, lastName, street, houseNumber, city,state, zipcode.
```
The above variables being together it's obvious that is an address, but adding a prefix could provide imformation. For example, if a User clase has name but also an address.

This way It becomes clearer what each one is used.
```user.getFirstName()``` **vs** ```user.getAddrFirstName()```
### Functions
- They're very **small.**
- They must do **one thing.**

  ❌ **Bad example**

  We have this function that does tow things. violing this principle.
  ```java
  public Integer readNumbersFromFileAndCalculateTotal(String fileUrl) {
    List<String> numbers =
        Files.readAllLines(Paths.get(fileUrl), StandardCharsets.UTF_8);

    Integer total = 0;
    for (String numberString : numbers) {
        total += Integer.valueOf(numberString);
    }

    return total;
  }
  ```
  ✅**Good example**

  Now with the refactored code, you can see that each function does just one thing and does the same thing as the previous one,making it easier to read.
  ```java
  public Integer getMonthlySales() {
    List<String> sales = readNumbersFromFile(MONTHLY_SALES_FILE_PATH);
    return calculateSummatory(sales);
  }

  public List<String> readNumbersFromFile(String fileUrl) {
    return Files.readAllLines(Paths.get(fileUrl), StandardCharsets.UTF_8);
  }

  public Integer calculateSummatory(List<String> values) {
    Integer total = 0;
    for (String numberString : values) {
        total += Integer.valueOf(numberString);
    }

    return total;
  }

  ```


- **Single level of abstraction**.

  ❌ **Bad example**

  This clase performs functions that are not part of its responsabilities. 
  ```java
  public class Person {

    public void drive(Car car) {
        car.openDoor();
        car.setDriver(this);
        car.getBattery().connect();
        car.getEngine().start();
    }
  }
  ```
  ✅ **Goog example**
  
  However, in this version the Person clase only handles its functions and the Car class handles its own.
   ```java
   public class Person {

    public void drive(Car car) {
        car.openDoor();
        car.setDriver(this);
        car.start();
    }
  } 
  ```
  ```java
  public class Car {
    Battery battery;
    Engine engine;

    public void start() {
        battery.connect();
        engine.start();
    }
  }
  ```
- They receive **few arguments.**
- They have no side effects.
- Return **exceptions** instead of error codes.

#### Code smell in functions
- **Too many arguments**
  - ⚠️**Avoid the functions with >3 arguments**⚠️
  - Divide the function in functions  smaller or encapsulating the arguments in a class.
- **output arguments:** Avoid passing output arguments in the functions.
  
  ❌ **Bad example**
  ```java
  public void calculateSum(List<Integer> numbers, int result) {
  ```  
  ✅ **Goog example**

  instead it should return the result.
    ```java
  public int calculateSum(List<Integer> numbers) {
  ```  
- **Passing flags in the arguments:** Avoid passing boolean, it often indicates that the function is doing more of one thing. In the next expamle the better is make tow functions to each type item.
   ```
  private static final Double PREMIUM_DISCOUNT_FACTOR = 0.2;
  private static final Double REGULAR_DISCOUNT_FACTOR = 0.1;

   public Double calculateDiscount(Item item, boolean isPremium) {
    if (isPremium) {
        return item.getPrice() * PREMIUM_DISCOUNT_FACTOR;
    }

    return item.getPrice() * REGULAR_DISCOUNT_FACTOR;
  }
   ``` 
- **Died functions:** These are unused functions; these usually indicate that the function does more than one thing. In the following example, it would be best to create two methods for each item type.
### Comments
- Add comments just when strictly necessary.
- They're very **difficult to maintain,** code change a lot and comments become **quickly outdated.**
- If the code has many comments, can be for tow reasons:
  - The code is not understood => Refactoring.
  - The comments are obvious => delete comments.

  ❌ **Bad example**
  ```java
  //Chek if password is  ServiceForEfficientUpdateMysqlDatabase
  if(password != null && password.length > 9 &&!password.contains(username))
  ```
  ✅ **good example**
   ```java
   if(isSecure(password))
   ```

- Never leave code commented out the is no longer being used. **¡that's why we have version control systemz!**

#### Code smells in comments
- **Inappropiate information:** anything that is better in another system (e.g. versions control system)  
    ```java
     //@Author Mateo Josue
     //Create Date: 10-07-2025
     public class Comments
    ```
- **Comentarios reduntantes:** This type of comments not add value because they are too obvious.


    ```java
    /**
    *
    * @param a The first number
    * @param a The second number
    * @return a+b
    */
     public Integer add(Integer a, Integer b){
         return a +b;
     }
    ```
- **Comentarios obsoletos:** Any comment outdated must be updated or deleted, because it not add nothing.

    ```java
     private Date LastLoginDate; //Last login date as String (DD-MM-YYYY HH:MM)
    ```
- **Comentarios mal redactados**
  - Do not make spelling mistakes.
  - Don't comment on obvious things! You must be direct.
  - Make sure you understand.

#### Good comments
Complex regular expressions at a glance.  
```java
//Matches Dates in format dd/mm/yyyy
Pattern.matches("^(0[1-9]|[12][0-9]|3[01])([-/.])(0[1-9]|1[0-2])\\2(\\d{4})$")
```
Comments in critical locations that require code changes.   
```java
//TODO except this metod tochange when the client changes auth API
public void login(User user){
```

_The comments on a public API that **will use a lot of people** are another clear example of good comments._
### Code format
- Configure the IDE to automatically apply formats when saving changes.
- The **entire team must write under the same rules.**
- [Google styles guide](https://google.github.io/styleguide/)
- **Vertical format**. density, order and distance.
  
   ❌ **High density**

  This code has high density aand hinders reading. 
  ~~~~java
  public class Dog {
    String name;
    int age;
    boolean run;
    public Dog(String name, int age, boolean run) {
        this.name = name;
        this.age = age;
        this.run = run;
    }
    public void bark() {
        System.out.println(name  + " says Woof!");
    }
     public void run() {
         this.run=true;
    }
  } 
  ~~~~
  ✅ **Low density**

  It's much better to have code with blank lines separating grouped concepts.
  ```java
  public class Dog {
    String name;
    int age;
    boolean run;

    public Dog(String name, int age, boolean run) {
        this.name = name;
        this.age = age;
        this.run = run;
    }

    public void bark() {
        System.out.println(name + " says Woof!");
    }
    
    public void run() {
         this.run=true;
    }
  } 
  ```
 

  ❌ **Messy code**
  It's difficult to read the code if the functions don't follow an order.
  ```java
  public void c(){
  //...   
  }

  public void b(){
    //...   
  }
 
  public void a(){
     b();
     c();
  }
  ``` 


  ✅ **Ordered code**
  It's much better to have a function at the top,which in turn calls other functions that are declared in the calling order.
  ```java
  public void a(){
     b();
     c();
  }
  public void b(){
    //...   
  }
  public void c(){
  //...   
  }

  ```

  
  ❌ **Bad example**
  
  This code isn't separated correctly and hinders reading. 

  ```java
  public String getUserConfigAsString() {

      Session session = getSession();

      User currentUser = session.get(username);
      
      String configAsString = null;

      if (currentUser.isValid()){
       
        Config config = currentUser.getConfig();
        
        configAsString = parseConfig(config);
        } 

        return configAsString;
  }
  
  ```
  ✅ **Good example**
  However, this code does maintain a grouping by related concepts and separates different concepts.
   ```java
  public String getUserConfigAsString() {
      Session session = getSession();
      User currentUser = session.get(username);
      
      String configAsString = null;
      if (currentUser.isValid()){
        Config config = currentUser.getConfig();
        configAsString = parseConfig(config);
        } 

        return configAsString;
  }
  ```
- **Horizontal Format**. Density and indentation.
  
  ❌ **High density**

  This code is very compact
  and contains no spaces, which makes it difficult to read.
  ```java
   public int sumFourNumbers(Integer num1,Integer num2,Integer num3,Integer num4) {
        if (num1!=null&&num2!=null&&num3!=null&&num4!=null) {
            return num1+num2+num3+num4;
        }
        return 0;
  }
  ```

  ✅ **Low density**

  However, this code is more separated, using spaces to separate operators, parameters and conditionals, so it is easier to read.
  ```java
   public int sumFourNumbers(Integer num1, Integer num2, Integer num3, Integer num4) {
        if (num1 != null && num2 != null && num3 != null && num4 != null) {
            return num1 + num2 + num3 + num4;
        } 
        return 0;
  }
  ```


  ❌ **Bad identation**

  The code does not respect the margins and the flow of logic is not clearly visible.
  ```java
  public int sumFourNumbers(Integer num1,Integer num2,Integer num3,Integer num4) {
  if (num1!=null&&num2!=null&&num3!=null&&num4!=null) {
  return num1+num2+num3+num4;
  } 
  return 0;
  }
  ```
  - Always **follow the same identation rules.**
  - Recommended **2 or 4 spaces** of indentation
  - Recommended **maximum 100 characters,** after that amount, make a line break.

### Gestión de errores
Error handling can make your code very dirty, so it's worth paying attention to.

- Return **exceptions** instead of error codes



    ❌ **Bad example**

    The problem with this code is that they have to control all errors and the correct execution is not clearly seen.

    ```java
    public class DeviceController {

        public void sendShutDown() {
            DeviceHandle handle = getHandle(DEV1);
            //check the state of the device 
            if (handle != DeviceHandle.INVALID) {
                //save the state of the device in the record field
                DeviceRecord record = retrieveDeviceRecord(handle);
                //if not suspend, shut down
                if (record.getStatus() != DEVICE_SUSPENDED) {
                    pauseDevice(handle);
                    clearDeviceWorkQueue(handle);
                    closeDevice(handle);
                }else {
                    logger.log(“Device suspended. Unable to shut down”);
                }
            }else {
                logger.log(“Invalid handle for: ” + DEV1.toString());
            }
        }
    }
    ```

    ✅ **Good example**

    However, in this version, we can see the separation of responsibilities: while one function contains the logic and throws an exception in case of error, the other function handles errors.

    ```java
    public void sendShutDown() {
        try {
            tryToShutDown();
        } catch (DeviceShutDownError e) {
            logger.log(e);
        }
    }

    private void tryToShutDown() throws DeviceShutDownError {
        DeviceHandle handle = getHandle(DEV1);
        DeviceRecord record = retrieveDeviceRecord(handle);
        pauseDevice(handle);
        clearDeviceWorkQueue(handle);
        closeDevice(handle);
    }
    ```

    **Recommendation:** Have the try catch separate from a function, to have both functions working at a single level of responsibility.


- **Unchecked exceptions**
  
  **Unchecked exceptions** are exceptions that inherit from the Exception class and do not require immediate handling. However, **Checked exceptions** require us to throw them or catch them in a try catch block, as in the following code.

    ```java
    public class Driver {
        public void startDriving() {
            try {
                car.start();
            } catch (BatteryFailureException | EngineFailureException e) {
                logger.log("Could not start driving. Car failure: " + e);
            }
        }
    }

    public class Car {
        public void start() throws BatteryFailureException, EngineFailureException {
            battery.connect();
            engine.start();
        }
    }

    public class Battery {
        public void connect() throws BatteryFailureException;
    }

    public class Engine {
        public void start() throws EngineFailureException;
    }

    ```
    In this code, the **Battery** and **Engine** methods throw **Checked exceptions** type exceptions, so each method that invokes them must throw those exceptions or capture them. However, if they were **Unchecked exceptions**, they would only be captured in the **startDriving** method.mbio si fueran **Unchecked exceptions** solo se capturan en el metodo **startDriving**.

- Nunca devolver **null**

  ❌ **Bad example**
  
  Devolver **null** nos obliga a validarlo siempre, y si no se valida en cada vez que se invoque un metodo de devuelva **null** se lanzaria una **NullPointerException.**

  ```java
  public void processRequestBatch() {
    List<Request> requestList = getRequestList();
    if (requestList != null) {
        for (Request r : requestList) {
            processRequest(r);
        }
    }
  }

  ```

  ✅ **Good example**

  However, if the ``` getRequestList()``` method returns an empty object instead of **null**, that unnecessary validation is skipped.
  ```java
  public void processRequestBatch() {
    List<Request> requestList = getRequestList();
    for (Request r : requestList) {
            processRequest(r);
        }
  }

  ```
    - Nunca pasar **null**

    ❌ **Bad example**
    
    In this example, the same thing happens as in the previous case, passing null as a parameter forces us to perform unnecessary validations, and if a method does not validate **null**, a **NullPointerException** would occur.**null** ocurriria una **NullPointerException**
    ```java
    public Point getMiddlePoint(Point a, Point b) {
        if (a != null && b != null) {
            Double resultPointX = (a.getX() - b.getX()) / 2;
            Double resultPointY = (a.getY() - b.getY()) / 2;

            return new Point(resultPointX, resultPointY);
        }

        // Return?
    }

    ```

    ✅ **Good example**

    On the other hand, if we do not send **null** as the value of a parameter, there would be no reason to perform that validation, although this case is more difficult than the previous one since we cannot control who is calling our method and how it is being implemented.
     ```java
    public Point getMiddlePoint(Point a, Point b) {
        Double resultPointX = (a.getX() - b.getX()) / 2;
        Double resultPointY = (a.getY() - b.getY()) / 2;

        return new Point(resultPointX, resultPointY);

    }
    ```

### Test unitarios
- Essential for code refactoring -
- Maintaining high coverage **(>90%)** offers great security when making changes to your functions.

#### Test Driven development 

**1.** Write a test,  watch it fail

**2.** Write just enoug code to past the rest

**3.** Improve the code without changin its behavior
### Code smells en el entorno desarrollo
- **Compilation Requires More Than One Step:** You should be able to compile the code in the simplest way possible.
- **Tests require more than one step**
- Tests should be run with a single command
- Danger of **Not running tests regularly out of "laziness"**.


### Code smells in Java
#### Lista de imports muy largas
- If you use **2 or more** classes from a package, import the entire package:

_import package.*_
- We don't want to clutter up our modules with 100 lines of imports.

- **Inheriting constants:**

 ❌ **Bad example**

In this example, the **EasyGame** class inherits from **Game**, which in turn implements the **GameConstants** interface. Ultimately, the **EasyGame** class inherits that constant, but it's very confusing to do it this way.
  ```java
  public class EasyGame extends Game {
    private int currentLevel;

    public Double calculateProgress() {
        return currentLevel / (double) NUMBER_OF_LEVELS;
    }
  }

  public abstract class Game implements GameConstants {
    public abstract Double calculateProgress();
  }

  public interface GameConstants {
    public static final int NUMBER_OF_LEVELS;
  }

  ```

  ✅ **Good exampleo**

  Instead, it would be recommended to use the constant directly from the class or statically import the classes with the constants.
   ```java
  public Double calculateProgress() {
        return currentLevel / (double) GameConstants.NUMBER_OF_LEVELS;
    }
  ``` 


- **Enums vs Constants**
  
  Use enums whenever possible as they provide abstract functions, which save us from having to perform validations when using constants.
  ```java
  public class Game {
    private int currentLevel;
    DifficultyLevel difficultyLevel;

    public int levelsLeft() {
        return difficultyLevel.numberOfLevels() - currentLevel;
    }
  }
  ``` 

  ```java
  public enum DifficultyLevel {
    EASY {
        public int numberOfLevels() {
            return 20;
        }
    },
    MEDIUM {
        public int numberOfLevels() {
            return 30;
        }
    },
    HARD {
        public int numberOfLevels() {
            return 50;
        }
    };

    public abstract int numberOfLevels();
  }
  ``` 
## principles solid
They are a set of principles proposed by Robert C. Marin that will help us:
- Create **scalable software**
- Create a **clean and maintainable architecture**
- Write code that is **easier to read** and understand
- Create modules with high **cohesion and loose coupling**
