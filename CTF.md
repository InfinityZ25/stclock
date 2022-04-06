# Simple Time Clock Applicaton

A simple time clock application that allows you to clock in, out, & go on break with a few constraints.

## Objectives

- [X] UUID per employee, do not allow interaction with application without a valid UUID.
- [X] Allow users to clock in and out. (no multiple shifts at once, start or end).
- [X] All shift data performed by users should be recorded & made available upon returning to the application. (preserve state).
- [ ] Allow users to go on break (unpaid) (no multiple breaks at once, start or end). Also allow to go on lunch which is a paid break of shorter, prespecified duration.
- [X] Create an endpoint to allow new users to register (require a token and expose in different uri if possible).

## Extras

- [ ] Create a simple frontend using react with tailwindscss.
- [ ] Allow for multiple stores to be created. (by default flatfile to json).
- [ ] Add seperate tasks to constantly validate the state of the application. (users that forget to clock out, or forgot to clock in, etc).
