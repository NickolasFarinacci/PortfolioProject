# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## 2025.11.20

### Added

- Designed kernel implementation for Inventory component

### Updated

- Changed design to include ...
  - Design no longer utilizes generic types and instead requires Inventory to store String and integers respectively.
  - Updated standard methods to fit for Inventory implementation
  - Created kernal methods to add/remove keys and values within Inventory. Moreover, methods were made to see what values were stored where and to see how many values total are stored.
  - Changes were also made to abstract class and interfaces to accomadate for the change from generic types to concrete types.

# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## 2025.11.07

### Added

- Designed abstract class for Inventory component

### Updated

- Changed design to include ...
  - Updated contracts that account for potential errors caused from casting. Casting also necessary to maintain created generic types within Inventory component.
  - Abstract class utilizes a map along with a constant for the maximum items contained within Inventory to ensure a defined upper limit.
  - Includes toString, equals, and hashcode methods in addition to previously identified secondary methods.

# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## 2025.10.22

### Added

- Designed kernel and enhanced interfaces for Inventory component

### Updated

- Changed design to include ...
  - Independent Inventory.Pair nested interface within Inventory itself.
  - Formal contracts noting alterations made when Inventory methods are called, requires and ensures clauses, and depicting what each method achieves.

# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## 2025.10.08

### Added

- Designed a proof of concept for the inventory component

### Updated

- Changed design to include...
  - Map component that stores material type (String) as the key and the amount of the item as an integer.
  - Added methods to display the amound of an item and add/remove an amount of that item from the inventory.
  - Implemented the methods as instances and demonstrated the application of each method within a main method

# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## 2025.09.19

### Added

- Designed an Inventory component
- Designed a Music Playlist component
- Designed a Playable Character component

# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## 2025.10.08

### Added

- Designed a proof of concept for the inventory component

### Updated

- Changed design to include ...
    * Map component that stores material type (String) as the key and the amount
    of the item as an integer.
    * Added methods to display the amound of an item and add/remove an amount of that item from the inventory.
    * Implemented the methods as instances and demonstrated the application of each method within a main method 
