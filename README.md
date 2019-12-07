# \*warn-on-reflection*

Demonstrating the behavior of `(set! *warn-on-reflection* true)` when added to the `user.clj` of a Clojure project.

## Rationale

Some people would like to have `*warn-on-reflection*` to be `true` by default when they launch their development REPL sessions. A naive advice would be to add `(set! *warn-on-reflection* true)` to `user.clj` but as this example shows that doesn't appear to work.

The search continues. If you happen to know a good way, please let me know.

## Relevant links:

- [user.clj](https://clojureverse.org/t/how-are-user-clj-files-loaded/3842/2)
- \*warn-on-reflection*
  - [Official docs](https://clojure.github.io/clojure/clojure.core-api.html#clojure.core/*warn-on-reflection*)
  - [Clojuredocs](https://clojuredocs.org/clojure.core/*warn-on-reflection*)
- [nREPL](https://nrepl.org/)
- [Clojure](https://clojure.org/)

## Usage

### Clojure cli tools

```text
> clj
Clojure 1.10.1
user=> (p)
Initial:
{:warn-on-reflection false,
 :thread
 {:daemon false,
  :name "main",
  :alive true,
  :priority 5,
  :id 1,
  :interrupted false}}

After initial set:
{:warn-on-reflection true,
 :thread
 {:daemon false,
  :name "main",
  :alive true,
  :priority 5,
  :id 1,
  :interrupted false}}

After repl start:
{:warn-on-reflection false,
 :thread
 {:daemon false,
  :name "main",
  :alive true,
  :priority 5,
  :id 1,
  :interrupted false}}

After setting from repl:
{:warn-on-reflection true,
 :thread
 {:daemon false,
  :name "main",
  :alive true,
  :priority 5,
  :id 1,
  :interrupted false}}
nil
```

### nREPL

```text
> clj -A:nrepl
nREPL server started on port 53193 on host localhost - nrepl://localhost:53193
nREPL 0.6.0
Clojure 1.10.1
Java HotSpot(TM) 64-Bit Server VM 1.8.0_231-b11
Interrupt: Control+C
Exit:      Control+D or (exit) or (quit)
user=> (p)
Initial:
{:warn-on-reflection false,
 :thread
 {:daemon false,
  :name "main",
  :alive true,
  :priority 5,
  :id 1,
  :interrupted false}}

After initial set:
{:warn-on-reflection true,
 :thread
 {:daemon false,
  :name "main",
  :alive true,
  :priority 5,
  :id 1,
  :interrupted false}}

After repl start:
{:warn-on-reflection false,
 :thread
 {:daemon true,
  :name "nRepl-session-756a0c69-8f8f-4100-a61f-6c758f9d4fd5",
  :alive true,
  :priority 5,
  :id 15,
  :interrupted false}}

After setting from repl:
{:warn-on-reflection true,
 :thread
 {:daemon true,
  :name "nRepl-session-756a0c69-8f8f-4100-a61f-6c758f9d4fd5",
  :alive true,
  :priority 5,
  :id 15,
  :interrupted false}}
nil
```
