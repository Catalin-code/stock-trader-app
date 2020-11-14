# StockTrader

## Story

Stock trading, also known as refers to the buying and selling of shares in a particular company; if you own the stock, you own a piece of the company. Trading is indeed a very stressful profession.
One thing is important regarding stock trading: [If what you are doing right now is not making you money. Why not try the opposite approach?](http://www.dstockmarket.com/the-funniest-trading-story-i-have-ever-heard-that-will-make-you-laugh.html)
One of your friends decided to invest some money into promising stocks. But of course, he needs to know
what are the options. As a fellow developer he simply started to write a stock trading application.
By the way, he is not so sure is it good or bad? He wanna cover his work with unit tests,
and follow higher standards but he has only limited affordable time for this project.
So he turns to you for help.
Now you have to review and refactor his code to make it testable and guess what, easily extendable
in sake of a better future development experience.

You don't hesitate and start dive into some unit testing industry standard to make his code fabulous.

## What are you going to learn?

You'll learn:

- dependency injection design pattern
- how to create lousily coupled classes
- using mocks, stubs (test doubles) objects
- using a mocking framework
- generating test report

## Tasks

1. Refactor logging functionality to a more future-proof version
    - `FileLogger` is not a singleton
    - We can define a new logger type, e.g. DBLogger without changing the previously created logger class

2. Make `RemoteURLReader` is easy to mock
    - Method `readFromUrl()` can be mocked by Mockito without any further Maven dependency

3. Refactor Stock API service
    - There are no hidden dependencies in `StockAPIService`. The caller knows of every outer dependencies of the class when creates an object from it.
    - When call `getPrice()` method if the given symbol does not appear in the response, it throws an `IllegalArgumentException` with a message: `"Symbol does not exist!"`

4. Refactor `Trader` class
    - There are no hidden dependencies in `Trader`. The caller knows of every outer dependencies of the class when creates an object from it.

5. Cover `StockAPIService` class with unit tests
    - The `getPrice()` method has a unit test for existing symbol when it should return with a valid value
    - The `getPrice()` method has a unit test for non-existing symbol when it should throw an `IllegalArgumentException` with the message: `Symbol does not exist!`
    - The `getPrice()` method has a unit test for the case when `RemoteURLReader` throws any exception
    - The `getPrice()` method has a unit test for the case when the received response has invalid json format. In this case it should throw a `JSONException`.

6. Cover `Trader` class with unit tests
    - The `buy()` method has a unit test for passing lower bid than price. In this case it should return false.
    - The `buy()` method has a unit test for passing higher bid than price. In this case it should return true.
    - The `buy()` method has a unit test for passing a non-existing symbol. In this case it should throw an `IllegalArgumentException` with the following message: `Symbol does not exist!`

## General requirements

- Dependency injection applied:
- there are no static variables / methods
- each class has only one instance which is created in `main`
- Unit tests should not do any real remote calls or file IO operation.

## Hints

- Unit tests should not do any remote calls or file IO, you should mock out these calls!
- TBD


## Starting your project



## Background materials

- <i class="far fa-exclamation"></i> [Dependency injection](project/curriculum/materials/pages/general/dependency-injection.md)
- <i class="far fa-exclamation"></i> [Mocking](project/curriculum/materials/pages/general/mocking.md)
- <i class="far fa-exclamation"></i> [Unit tests, stubs, mocks quick overview by Martin Fowler](https://www.youtube.com/watch?v=sEFhB71tmPM)
- <i class="far fa-exclamation"></i> [Unit test best practices](https://www.youtube.com/watch?v=ybDhy7b2i2o)

