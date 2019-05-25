Yet another calculator
=

Run NetworkReader with argument <Port Number>

Use telnet to connect to <Port Number>

Type commands

```
add <NUM>
multiply <NUM>
substract <NUM>
divide <NUM>
```

Finish input by 

```
apply <NUM>
```

Resulted communication flow can be like this:
```
$telnet localhost 5000
Trying 127.0.0.1...
Connected to localhost.
Escape character is '^]'.
add 5
Command "add" arg: "5.0"
multiply 8
Command "multiply" arg: "8.0"
substract 3
Command "substract" arg: "3.0"
apply 7
Stack size: 3
Used command "add" result: 12.0
Used command "multiply" result: 96.0
Used command "substract" result: 93.0
Final result: 93.0
```