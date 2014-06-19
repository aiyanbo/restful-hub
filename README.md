restful-hub
===========
[![Build Status](https://travis-ci.org/aiyanbo/restful-hub.svg?branch=master)](https://travis-ci.org/aiyanbo/restful-hub)

Helps you build a RESTful server of beauty

###状态处理###

```js

{
    "uri": "Domain uri",
    "identity": "id",
    "created_at": "created time"
}

```

###Using###

```java

Success.Created.build(args);
Success.Deleted.build(args);
Success.Updated.build(args);

```

###错误处理###

```js

{
    "message": "Error message",
    "errors": [
        {
            "code": "error code",
            "message": "exception details"
        }
    ]
}

```

###JAX-RS###

```java

context.register(RestfulhubFeature.class);

```
