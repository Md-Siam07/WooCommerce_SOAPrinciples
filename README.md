# WooCommerce Application

## Overview

WooCommerce is a SOAP-based application designed for seamless e-commerce operations. The application facilitates a smooth order flow where customers can place orders, and sellers manage their respective portals. The architecture follows Service-Oriented Architecture (SOA) principles, ensuring schema centralization, loose coupling, and service reusability.

## Order Flow

1. **Customer Order Placement:**
   - Customers place orders from the shop.
   - The order's validity is checked. An order is valid if:
      - All the products contained in the order are valid
      - The items are in stock.
   - The order is initially in the pending state.
   - A notification is sent to the seller upon order placement.
   - A log message is generated for the order placement.

2. **Seller Order Management:**
   - Sellers can confirm or decline an order.
   - Upon confirmation:
      - The stock of the respective products is updated.
      - A notification is sent to the customer upon order confirmation.
      - A log message is generated for the order confirmation.

## Services

### Entity Services
- **Customer Service:** Provides CRUD operations for customers.
- **Seller Service:** Manages seller information and operations.
- **Order Service:** Handles order placement, updates, and queries.
- **Product Service:** Manages product details and inventory.

### Utility Services
- **Notification Service:** Sends notifications to customers and sellers.
- **Logging Service:** Records log messages for various events.

### Task Service
- **ManageOrder Service:** Orchestrates the other services to manage the order flow.

### Common Service
- **Common Service:** Contains common schemas used across the system.

## SOA Principles

WooCommerce is built upon the following SOA principles:

### 1. Service Contract and Standardization

Service contracts were standardized using some Functional Expression Standard and Data Representation Standards

#### Standardized WSDL Definitions
All WSDL definitions in WooCommerce have been standardized to ensure consistency and clarity. The following conventions are followed:

- **Entity Services:** Named according to the corresponding business entities they represent.
- **Task Services:** Named based on the process they automate, prefixed with an appropriate verb.
- **Operations:** Named using the format: verb + noun.

###### Examples
- `getProductRequest` Operation
- `getProductResponse` Operation
- `manageCreateOrderRequest` Operation

#### Standardized Service and Data Representation Layers
Schema centralization is implemented by reusing predefined schemas and defining new schemas only when necessary. This approach maintains a centralized repository for all schemas, ensuring consistency and reuse across the application. Some of the examples are:
- `Product` schema is broken down to `ProductHeader` and `Product`
- `StatusCode`, `fault` was moved to `CommonService` and reused in all services
- `ManageOrder` reuses the schemas defined in `Order, Product` 

### 2. Loose Coupling
All services are designed to be loosely coupled, meaning they operate independently of each other. No service depends on any other service except for the ManageOrder service. This reduces dependencies and increases the flexibility and maintainability of the system. Even logging and notifications are managed by the ManageOrder service to avoid direct dependencies among other services.

### 3. Abstraction
Service abstraction is achieved through WSDL (Web Services Description Language). The implementation details of each service are hidden, allowing clients to interact with services via well-defined interfaces without needing to understand the underlying implementations. This abstraction facilitates easier integration and usage of the services.

### 4. Reusability
Services are implemented in a reusable manner, allowing common functionalities to be abstracted into utility services. This promotes the reuse of existing services and components, reducing redundancy and development time for new features.

### 5. Autonomy
Each service, except for the ManageOrder service, is self-contained and autonomous. This means they operate independently and do not rely on the state or behavior of other services, ensuring high reliability and fault tolerance.

### 6. Statelessness
Services are designed to be stateless. Each service call is independent and does not rely on previous interactions. This stateless nature simplifies scaling and maintenance, as services do not need to retain information about previous requests.

### 7. Composability
Services are designed to be composable, allowing them to be combined to form more complex operations. The ManageOrder service orchestrates other services to handle the order flow, demonstrating the composability and flexibility of the architecture.

### 8. Discoverability
Services are discoverable by using there WSDL.

## How to Install

To install and run the WooCommerce application, follow these steps:

1. **Ensure Ports 8081 to 8089 are Free:**
   - Make sure that ports 8081 to 8089 are free and unused on your system to avoid conflicts.

2. **Clone the Repository:**
   ```sh
   git clone https://github.com/Md-Siam07/WooCommerce_SOAPrinciples.git
   cd WooCommerce_SOAPrinciples
   
3. **Load Each Folder into IntelliJ:**
   - Open IntelliJ IDEA.
   - Load each folder (e.g., Customer, Seller, Order, Product, Notification, Logging, ManageOrder, Common) as distinct projects. To do this:
   - Click on File > Open.
   - Select the folder and click OK.
   - Follow the prompts to load the project.
     
4. **Run the Projects:**
   - For each loaded project, configure the run configurations if necessary.
   - Run the project to start the respective service.
   
## Conclusion

WooCommerce is a robust and flexible application built with a focus on modularity, reusability, and adherence to SOA principles. This ensures a high-quality architecture that can easily adapt to changing business requirements while maintaining efficiency and reliability.

## Contact

For any queries or further information, please contact the development team at [bsse1104@iit.du.ac.bd].
