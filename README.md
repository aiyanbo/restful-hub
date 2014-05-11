restful-hub
===========
[![Build Status](https://travis-ci.org/aiyanbo/restful-hub.svg?branch=master)](https://travis-ci.org/aiyanbo/restful-hub)

restful-hub 旨在帮助你构建一个更好的RESTful 服务，它架构在 JAX-RS API 之上。

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
