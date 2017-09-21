# CIS655 - Lab 01 - Matías Gil Echavarría
Safe Threading in Java

### PROGRAM A: Not safe Threading example.
| Number of Threads | N*1000000 | Final Counter | Final Counter = N*1000000 ? | Execution Time (ms) |
|-------------------|-----------|---------------|-----------------------------|---------------------|
| 2                 | 1645643   | 2000000       | No                          | 38                  | 
| 4                 | 2545558   | 4000000       | No                          | 55                  |
| 6                 | 5357585   | 6000000       | No                          | 97                  |
| 8                 | 6255646   | 8000000       | No                          | 85                  |
| 16                | 15095934  | 16000000      | No                          | 83                  |
| 32                | 28548220  | 32000000      | No                          | 113                 |

1. Is the counter always equal to n * 1000000, where n is the number of thread created? Explain why or why not.
**ANSWER:** It is never equal to n * 1000000 and the reason for this is that my algorithm on this case is non thread safe. It means that the counter is being accessed by differente process' threads so when a particular thread is incrementeing it, there are more threads that are doing the same thing so they are always getting the counter to perform the increment with a different value overwriting it and losing the correct count number.


### PROGRAM B: Safe Threading example.
| Number of Threads | N*1000000 | Final Counter | Final Counter = N*1000000 ? | Execution Time (ms) |
|-------------------|-----------|---------------|-----------------------------|---------------------|
| 2                 | 2000000   | 2000000       | Yes                         | 117                 |
| 4                 | 4000000   | 4000000       | Yes                         | 197                 |
| 6                 | 6000000   | 6000000       | Yes                         | 327                 |
| 8                 | 8000000   | 8000000       | Yes                         | 369                 |
| 16                | 16000000  | 16000000      | Yes                         | 636                 |
| 32                | 32000000  | 32000000      | Yes                         | 1356                |

2. Is the counter always equal to n * 1000000, where n is the number of thread created? Explain why or why not.
**ANSWER:** It is always equal and the reason for this is that my algorithm on this case is thread safe. It means that the counter is accessed by one and only one thread at the time so the counter always will be increased using the correct *"current value"* of it. Thats whay on this program B it works well. It is done using a synchronized methods to avoid a particular thread using it while another one is performing the same method. 

3. Analyze the differences in elapsed time between Program A and Program B. Is there a significant difference? Explain why or why not.

**ANSWER:** The notable differences are just because on the safe thread program every thread needs to wait the current execution to finish to be executed. This flow obviously will take more time than the non safe thread flow because it will just execute the increment method as fast as it can and it will not spend time waiting for other threads to be executed.
