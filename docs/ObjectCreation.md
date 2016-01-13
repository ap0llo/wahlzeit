Object Creation
================

CartesianCoordinate
-------------------
- Delegation: **On-the-spot**
- Selection: **On-the-spot**
- Configuration: **In code**
- Instantiation: **In code**
  (though the constructor is private, and has been replaced by static
  *newInstance* method to enable sharing of instances)
- Initialization: **Default**
- Building: **Default**

###Object Creation Calls
    CartesianCoordinate::newInstance()
    CartesianCoordinate::getOrCreateInstance()
    CartesianCoordinate::new()    

--------------------------------------------------------------------------------


SphericCoordinate
-----------------
- Delegation: **On-the-spot**
- Selection: **On-the-spot**
- Configuration: **In code**
- Instantiation: **In code**
  (though the constructor is private, and has been replaced by static
  *newInstance* method to enable sharing of instances)
- Initialization: **Default**
- Building: **Default**

###Object Creation Calls
    SphericCoordinate::newInstance()
    SphericCoordinate::getOrCreateInstance()
    SphericCoordinate::new()

--------------------------------------------------------------------------------


Location
--------
- Delegation: **On-the-spot**
- Selection: **On-the-spot** (no subclasses present)
- Configuration:  **In code**
- Instantiation: **In code**
- Initialization: **Default**
- Building: **Default**

###Object Creation Calls
    Location::new()

--------------------------------------------------------------------------------


ConcertType
------------
- Delegation: **By delegating to a separate object** (ConcertTypeFactory)
- Selection: **On-the-spot** (no subclasses present)
- Configuration:  **In code**
- Instantiation: **In code**
- Initialization: **Default**
- Building: **Default**

###Object Creation Calls
    PhotoManager::createPhoto()
    PhotoUtil::createPhoto()
    ConcertPhotoFactory::createPhoto()
    ConcertTypeFactory::getConcertType()
    ConcertType::new()

--------------------------------------------------------------------------------


Concert
-------
- Delegation: **By delegating to a separate object ** (ConcertType)
- Selection: **On-the-spot** (Concert is not part of a class hierarchy)
- Configuration: **In code**
- Instantiation: **In code**
- Initialization: **In second step** (associated ConcertType is passed to
   constructor, other fields can then be set by client)
- Building: **Default**

###Object Creation Calls
    PhotoManager::createPhoto()
    PhotoUtil::createPhoto()
    ConcertPhotoFactory::createPhoto()
    ConcertTypeFactory::getConcertType()
    ConcertType::new()
    ConcertType::createInstance()
    Concert::new()

--------------------------------------------------------------------------------


ConcertPhoto
------------
- Delegation: **By delegating to a separate object ** (ConcertPhotoFactory)
- Selection: **On-the-spot** (ConcertPhotoFactory always creates instances of
   this concrete class)
- Configuration: **In code**
- Instantiation: **In code**
- Initialization: **In second step**
- Building: **By building**

###Object Creation Calls
    PhotoManager::createPhoto()
    PhotoUtil::createPhoto()
    ConcertPhotoFactory::createPhoto()
    ConcertPhoto::new()
