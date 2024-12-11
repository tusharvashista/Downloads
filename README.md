Part 2: Java question

You are going to make a system that manages a pet care service: that is, a service that looks after animals when the owners may be away. Each animal is housed in its own enclosure at the service.

The tasks will get harder as you progress, and build on each other, so try to ensure that you complete each stage before moving on. Be sure to read through the entire specification before you begin to get a sense of all the features that might be needed.

In each task, marks will be awarded for clean code and sensible object-oriented design choices as well as functionality.

Java Task 1: Representing an animal (10 marks)

Download this Java starter package.

We have provided initial versions of an enumerated type AnimalSize and the skeleton of the Animal class that you should use for this task, which are both in the petcare package. You must use these classes: do not change the name of the classes or the package.

For our purposes, an animal has the following properties:

-        Name: Each animal has a name which must be at least 3 characters long.

-        Size: An animal can be one of three sizes: small, medium, or large.

-        Comfortable temperature: Animals need to be kept within a specific temperature range to be comfortable. Each animal will have a range they must stay within, which must be expressed as a lower and upper bounding integer, both in the range 0 to 50 – an animal is comfortable in an enclosure as long as the temperature is between those two values. 

 

Task 1a [4 marks]

Write some code to represent an animal so it can be stored in the system. You should use the provided Animal class as the starting point for this class, but the specific details of the implementation are up to you. Make sure to include a constructor that sets all properties.

 

Task 1b [2 marks]

Add getter and setter methods for all the values and override the toString() method and equals()/hashCode() methods. The equals method should return true when two animals are the same size and have the same name.

 

Task 1c [4 marks]

Ensure that all the values that are stored are valid, following the specification above. If someone tries to create or update an animal with invalid values, then an IllegalArgumentException should be thrown, and the change should not take effect.

 
 

Java Task 2: Enclosures and checks (15 marks)

An enclosure is a cage or pen that the pet care service maintains to keep one of the animals they are looking after in. Enclosures have:

-        Size: Each specific enclosure is rated to look after animals up to the size of small, medium or large.

-        Temperature: Each enclosure has a specific temperature that it is maintained at.

-        Running costs: Each enclosure costs a certain amount to run each day, which can be expressed as an integer.

-        Current occupant: If there is an animal in the enclosure, they should be stored, otherwise the value of occupant should be null.

 

Task 2a [4 marks]

Create a class called Enclosure that stores this information. The class should have a constructor that takes in a size, temperature, and running costs when it is created and set the occupant to null. The class should have getter methods for all the variables but no setters.

 

Task 2b [5 marks]

Write a method with the signature:
              

public boolean checkCompatibility(Animal animal)

When passed an animal, the method checks whether the enclosure can take the animal and returns true if it can. For an animal to be compatible with an enclosure, the animal must be of the same size or smaller than the size an enclosure is rated for, and the enclosure’s temperature should fall within the animal’s comfort range.

Task 2c [6 marks]

Write a pair of methods with the signatures:

 

public void addAnimal(Animal animal)

     public void removeAnimal()

When called, these methods should, respectively, add an animal to the Enclosure if it is compatible and does not already have an occupant, and remove the animal currently in the enclosure. If the animal cannot be added, then throw an IllegalArgumentExcepion. If removeAnimal is called on an empty enclosure, nothing should happen.

 

 
 

Java task 3: The pet care service (15 marks)

The pet care service manages a collection of enclosures, and animals are allocated to enclosures as they arrive. Additional enclosures can be added to the service as needed.

Task 3a [3 mark]

Write a class called PetService to represent the pet care service, which stores a single piece of information: the collection of enclosures that it manages, which should be initially empty.

 

Task 3b [4 marks]

Add methods to the PetService class to maintain and print the enclosures that it manages.

Add a method to the class with the following signature:

              

public void addEnclosure(Enclosure enclosure)

When called, this method should add the given enclosure to the enclosures that the pet service has.

Add a second method with the signature:

public void printAllEnclosures() 

This should print out the details of all the enclosures that the service maintains.

Task 3c [4 marks]

In this task you will handle adding an animal into the pet service’s care.

Add a method with the signature:

 

public boolean allocateAnimal(Animal animal)

When called, this method should find the best enclosure to allocate an animal based on the following criteria:

-        The enclosure must meet all the requirements for the animal (size, temperature).

-        The enclosure cannot have another animal staying within it.

-        If more than one enclosure meets the requirements, the animal should be allocated to the cheapest one (i.e., the one with the lowest running cost), and the method should return true.

-        If no appropriate enclosure is available, then no changes should be made to the pet service and the method should return false.

 

Task 3d [4 marks]

Finally, add a method with the signature:

 

public void removeAnimal(Animal animal)

When called, this method should search for a matching animal within the enclosures of the pet service. If a matching animal exists, it should be removed from its enclosure. If the animal does not exist in the system, then the method should throw an IllegalArgumentException.

Submission

Upload all of your Java files below: Animal.java, AnimalSize.java, Enclosure.java, and PetService.java.

Dont' have much time left just 10 mins plss hurry. 
