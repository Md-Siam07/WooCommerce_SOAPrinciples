# WooCommerce Application

## Overview

WooCommerce is a SOAP-based application designed for seamless e-commerce operations. The application facilitates a smooth order flow where customers can place orders, and sellers manage their respective portals. The architecture follows Service-Oriented Architecture (SOA) principles, ensuring schema centralization, loose coupling, and service reusability.

## Order Flow

1. **Customer Order Placement:**
   - Customers place orders from the shop.
   - The order is initially in the pending state.
   - A notification is sent to the seller upon order placement.
   - A log message is generated for the order placement.

2. **Seller Order Management:**
   - Sellers can confirm or decline an order.
   - Upon confirmation, the stock of the respective products is updated.
   - A notification is sent to the customer upon order confirmation.
   - A log message is generated for the order confirmation.

## Services

### Entity Services
- **Customer Service:** Manages CRUD operations for customer data.
- **Seller Service:** Manages CRUD operations for seller data.
- **Order Service:** Manages CRUD operations for order data.
- **Product Service:** Manages CRUD operations for product data.

### Utility Services
- **Notification Service:** Handles notifications to customers and sellers.
- **Logging Service:** Manages logging activities for various events.

### Task Service
- **ManageOrder Service:** Orchestrates the other services to manage the order lifecycle.

### Common Service
- **Common Service:** Contains common schemas reused across the system.

## SOA Principles

- **Schema Centralization:** Reuses predefined schemas and defines new schemas only when necessary.
- **Loose Coupling:** Services are designed to be independent. No service depends on another except for the ManageOrder service, which orchestrates other services.
- **Abstraction:** Implementation details are hidden through WSDL files, ensuring abstraction.
- **Reusability:** Services are implemented in a reusable manner.
- **Autonomy:** All services except for ManageOrder are self-dependent and autonomous.
- **Statelessness:** All services are stateless and composable.

## Technical Details

### Service Implementation

- **Customer, Seller, Order, Product Services:** Handle CRUD operations independently.
- **Notification and Logging Services:** Utilized by the ManageOrder service to avoid direct coupling with other entity services.
- **ManageOrder Service:** The only service that consumes and orchestrates other services, ensuring a streamlined order management process.

### Abstraction and WSDL

- The WSDL files provide a clear interface for each service, hiding the underlying implementation details and exposing only the necessary operations and data structures.

### Reusability and Autonomy

- Each service is designed for maximum reusability and can function independently of others, ensuring a flexible and maintainable architecture.

## Contact

For any queries or further information, please contact the development team at [bsse1104@iit.du.ac.bd].
