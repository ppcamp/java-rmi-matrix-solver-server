# Matrix multiply server method

* To compile files
    ```bash
    for i in *.java;do javac -d bin $i; done
    ```
* To execute operation
    ```bash
    # Inside bin folder
    rmic MatrixImplements # Generate Stub, responsable of client server communications
    java Server # To server start listen
    java Client # Compute operation
    ```
