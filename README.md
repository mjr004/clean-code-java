# Solid and clean code in Java
## Principles solid
#### names that reveal intention
names should be clear and reflect our intention.

❌ **Incorrect statement**  
```java
int d;
int m;
int m;
```
✅ **Correct statement** 
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

```java
public class ServiceForEfficientUpdateMysqlDatabase{
```
```java
public class ServiceForEfficientBackupMysqlDatabase{
```
avoid calling classes with names that are difficult to look up and name.

```java
Map<Integer, String> employeeList;
```
This is not actually a list, so adding the word List can be confusing.

```java
public class ProductData{}
public class ProductInfo{}
```
These two classes do not have a clear difference, therefore they can cause confusing.


#### Use pronounceable names

❌ **Incorrect statement** 
```java
String nn;
String ln;
```
✅ **Correct statement**
```java
String name;
String lastname;
```

❌ **Incorrect statement** 
```java
String nn;
String ln;
```
✅ **Correct statement**
```java
String name;
String lastname;
```

❌ **Incorrect statement** 
```java
String lstUsedName;
```
✅ **Correct statement**
```java
String leastUsedName;
```

- Avoid using abbreviations 
- It's much better to choose a very large name than one that doesn't convey it's meaning clearly.

#### Names of classes and methods
- The classes names must be **a name or set of names,** should not be verbs. 
- The methods must be **verbs,** indicating an action.
- Do not name a class ```CreateEmployee{```nor to a method ```EmployeeName() ```, fo example.

✅ **Correct statement **
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
- **Abstracctiion level** unique.
- They receive **few arguments.**
- They have no side effects.
- Return **exceptions** instead of error codes.


### Comments
- Add comments just when strictly necessary.
- They're very **difficult to maintain,** code change a lot and comments become **quickly outdated.**
- If the code has many comments, can be for tow reasons:
  - The code is not understood => Refactoring.
  - The comments are obvious => delete comments.

  ❌ **Incorrecto**
  ```java
  //Chek if password is  ServiceForEfficientUpdateMysqlDatabase
  if(password != null && password.length > 9 &&!password.contains(username))
  ```
  ✅ **Correcto**
   ```java
   if(isSecure(password))
   ```

- Never leave code commented out the is no longer being used. **¡that's why we have version control software!**

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
        System.out.println(name + " says Woof!");
    }
    
    public void run() {
         this.run=true;
    }
  } 
  ~~~~
 

  ❌ **Messy code**
  It's difficult to read the code if the functions don't follow an order.
  ~~~~java
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
  ~~~~ 


  ✅ **Ordered code**
  It's much better to have a function at the top,which in turn calls other functions that are declared in the calling order.
  ~~~~java
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

  ~~~~

  
  ❌ **Incorrect sepparating**
  
  This code isn't separated correctly and hinders reading. 

  ~~~~
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
  
  ~~~~
  ✅ **Correct separation**
  However, this code does maintain a grouping by related concepts and separates different concepts.
   ~~~
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
  ~~~
- **Horizontal Format**. Density and indentation.
  
  ❌ **High density**

  This code is very compact
  and contains no spaces, which makes it difficult to read.
  ~~~
   public int sumFourNumbers(Integer num1,Integer num2,Integer num3,Integer num4) {
        if (num1!=null&&num2!=null&&num3!=null&&num4!=null) {
            return num1+num2+num3+num4;
        }
        return 0;
  }
  ~~~

  ✅ **Low density**

  However, this code is more separated, using spaces to separate operators, parameters and conditionals, so it is easier to read.
  ~~~java
   public int sumFourNumbers(Integer num1, Integer num2, Integer num3, Integer num4) {
        if (num1 != null && num2 != null && num3 != null && num4 != null) {
            return num1 + num2 + num3 + num4;
        } 
        return 0;
  }
  ~~~


  ❌ **Bad identation**

  The code does not respect the margins and the flow of logic is not clearly visible.
  ~~~java
  public int sumFourNumbers(Integer num1,Integer num2,Integer num3,Integer num4) {
  if (num1!=null&&num2!=null&&num3!=null&&num4!=null) {
  return num1+num2+num3+num4;
  } 
  return 0;
  }
  ~~~
  - Always **follow the same identation rules.**
  - Recommended **2 or 4 spaces** of indentation
  - Recommended **maximum 100 characters,** after that amount, make a line break.