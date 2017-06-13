# memo
the server of the memo app



实现Android前端的网络接口:

```java
@POST("Server/user/login")
Observable<HttpResult<UserInfo>> login(@Field("userName") String userName, @Field("password") String password);

@GET("/Server/user/logout")
Observable<HttpResult<String>> logout();

@FormUrlEncoded
@POST("/Server/user/register")
Observable<HttpResult<String>> register(@Field("userName") String userName, @Field("password") String password, @Field("description") String description);

@FormUrlEncoded
@POST("/Server/user/addEvent")
Observable<HttpResult<String>> addEvent(@Field("userId") Integer userId, @Field("eventName") String eventName, @Field("content") String content, @Field("startTime") String startTime, @Field("endTime") String endTime);

@FormUrlEncoded
@POST("/Server/user/getEventByUserId")
Observable<HttpResult<List<Event>>> getEventByUserId(@Field("userId") Integer userId);
```
