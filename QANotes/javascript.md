# JavaScript 

**Runs between `<script></script>` tags.**

Use `let` to declare a variable. E.g. `let answer = 42;`star trek 

- JavaScript is loosely typed; variables don’t need to be given types. Variables can be re-declared as other types. E.g. `let answer = 42; let answer = “Fourty Two”;` 

- Variables declared with let are only accessible in the scope in which they are created. 

- Variables can also be declared with var. e.g `var answer = 42; // Legacy`

- Variables can also be declared with const. These must be initialised with a value, as they cannot be changed once created. 

- Functions are declared with the keyword function. E.g. `function thisFunction( ){ }`

- Functions can be written with arrow syntax, when all you want to do is return a value. E.g. `let thisFunction = => “Returned value”;`

## Closure 

**An inner function that has access to the outer function’s scope chain.**

Closure has: 

- Its own scope 
- Outer function scope 
- Global scope 

## Arrays 

- Arrays are not typed; they can contain any combination of data types. They are dynamically sized. 

- Array.push(“ElementToAdd” ) adds to an array, array.pop(“ElementToRemove” ) removes an item. 

- Javascript uses `forOf` loops: `for (let item of array){ }` 

- forEach loop syntax: `myArray.forEach(value, index, array){ }` 