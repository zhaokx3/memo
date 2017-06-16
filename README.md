# memo
the server of the memo app



实现Android前端的网络接口:

```java
@POST("/memo/user/login")
Observable<HttpResult<UserInfo>> login(@Field("userName") String userName, @Field("password") String password);

@GET("/memo/user/logout")
Observable<HttpResult<String>> logout();

@FormUrlEncoded
@POST("/memo/user/register")
Observable<HttpResult<String>> register(@Field("userName") String userName, @Field("password") String password, @Field("description") String description， @Field("avatar") String avatar);

@FormUrlEncoded
@POST("/memo/user/addEvent")
Observable<HttpResult<String>> addEvent(@Field("userId") Integer userId, @Field("process") Integer process, @Field("icon") Integer icon, @Field("category") Integer category, @Field("eventName") String eventName, @Field("content") String content, @Field("startTime") String startTime, @Field("endTime") String endTime, @Field("timestamps") String timestamps);

@FormUrlEncoded
@POST("/memo/user/changeEvent")
Observable<HttpResult<String>> changeEvent(@Field("userId") Integer userId, @Field("process") Integer process, @Field("icon") Integer icon, @Field("category") Integer category, @Field("eventName") String eventName, @Field("content") String content, @Field("startTime") String startTime, @Field("endTime") String endTime, @Field("timestamps") String timestamps);

@FormUrlEncoded
@POST("/memo/user/deleteEventByUserId_EventName")
Observable<HttpResult<String>> deleteEventByUserId_EventName(@Field("userId") Integer userId, @Field("eventName") String eventName);

@FormUrlEncoded
@POST("/memo/user/getEventByUserId")
Observable<HttpResult<List<Event>>> getEventByUserId(@Field("userId") Integer userId);
```
