Key differences and benefits of the "Tell Don't Ask" approach:
1. **Better Encapsulation**: In the good example, the `BankAccount` class encapsulates all the logic related to its balance. 
The internal state (`balance`) is truly private, and all operations are performed through behavior-focused methods.
2. **Single Responsibility**: Each object is responsible for its own data and behavior. The `BankAccount` knows how to handle its own balance and transfer operations.
3. **Reduced Dependencies**: The `TransferService` doesn't need to know about the internal implementation details of `BankAccount`. It just tells the account what to do.
4. **More Maintainable**: If we need to change how transfers work (e.g., add logging, validation, or transaction management), we only need to modify the `BankAccount` class.
5. **Less Prone to Errors**: By keeping the state and the operations that modify it together, we reduce the chance of inconsistent state changes.

This principle is particularly useful when:
- Working with complex domain objects
- Implementing business rules
- Managing state changes
- Designing APIs

Remember that "Tell Don't Ask" is a guideline, not a strict rule. There are legitimate cases where you need to query an object's state, particularly when dealing with value objects or when you need to display information to users. The key is to use this principle when it makes sense for your specific use case and leads to cleaner, more maintainable code.
