# WooCommerce Application

## Overview

WooCommerce is a SOAP-based application designed for seamless e-commerce operations. The application facilitates a smooth order flow where customers can place orders, and sellers manage their respective portals. The architecture follows Service-Oriented Architecture (SOA) principles, ensuring schema centralization, loose coupling, and service reusability.

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
All the services in our design exhibit a high level of logic-to-contract coupling because they are custom services for which standardized service contracts are delivered. The `Customer`, `Seller`, `Order`, and `Product` services are based on the entity service model, which deliberately decreases potential functional coupling to external or parent business process logic. The same applies to utility services such as `Notification` and `Logging`. 
`ManageOrder`, which is a task-centric service, is bound to WooCommerce’s business process, which is a very specific procedure within the WooCommerce application. As a result, this service shows targeted functional coupling, which is intentionally done during its design.

### 3. Abstraction
All services, except for the task service `ManageOrder`, adhere to the following levels of abstraction:

| **Abstraction Level**                  | **Description**                                                                                     |
|----------------------------------------|-----------------------------------------------------------------------------------------------------|
| **Functional Abstraction (Content Abstraction)** | **Concise:** The service contract provides targeted functionality with limited constraints.          |
| **Technology Abstraction (Access Control)**      | **Open Access:** The technologies used to build and implement this service are openly documented and published as part of architecture specifications. |
| **Programmatic Abstraction (Access Control)**    | **Open Access:** Source code and design specifications are openly available on the local LAN.        |
| **Quality of Service (Access Control)**          | **Open Access:** The SLA is published alongside the service contract.                                |

#### Exception: ManageOrder Service

The `ManageOrder` service deviates from the standard levels of abstraction due to its complex business flow associated with the exchange of order data.

#### Functional Abstraction (Content Abstraction)
- **Detailed:** Due to the complex business flow, this service’s contract has a low level of functional abstraction.

### 4. Reusability

All entity and utility services in WooCommerce are self-agnostic services. They do not rely on the reuse of other service capabilities. Instead, they function independently, providing reusable and modular functionalities that the task service can call upon when needed.

#### Task Service and Entity Services

The task service, `ManageOrder`, orchestrates operations involving multiple entity and utility services. For instance, during certain tasks, such as updating the order status from PENDING to CONFIRMED or DECLINED, multiple services are utilized.

##### Example: Updating Order Status and Product Stock

When an order is confirmed:
- The status of the order needs to be updated from PENDING to CONFIRMED.
- The stock of the product items needs to be updated accordingly.

Initially, the `updateProduct` method was used to update product stock. However, it required the entire product entity as input, which was inefficient for our needs. To address this, a more focused operation, `UpdateProductStock`, was implemented to specifically handle stock updates.

Similarly, the operation to update the order status was streamlined by creating the `UpdateOrderStatus` operation, not only relying on `UpdateOrder`. This approach ensures that operations are efficient and targeted, promoting better reusability and maintainability of the services.


### 5. Autonomy
Each service, except for the ManageOrder service, is self-contained and autonomous. This means they operate independently and do not rely on the state or behavior of other services, ensuring high reliability and fault tolerance.

### 6. Statelessness
Services are designed to be stateless. Each service call is independent and does not rely on previous interactions. This stateless nature simplifies scaling and maintenance, as services do not need to retain information about previous requests.

### 7. Composability
Services are designed to be composable, allowing them to be combined to form more complex operations. The ManageOrder service orchestrates other services to handle the order flow, demonstrating the composability and flexibility of the architecture.

### 8. Discoverability
Services are discoverable by using there WSDL.


## Conclusion

WooCommerce is a robust and flexible application built with a focus on modularity, reusability, and adherence to SOA principles. This ensures a high-quality architecture that can easily adapt to changing business requirements while maintaining efficiency and reliability.

## Contact

For any queries or further information, please contact the development team at [bsse1104@iit.du.ac.bd].
