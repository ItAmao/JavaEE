<%--
  User: ItAmao
  Date: 2020/7/24
  Time: 20:58
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<!--点击某个商品必须有区分商品的手段 ?name=值 表示传递的购买名称-->
<a href="/day12_cart/addCartServlet?name=三国演义">三国演义</a><br/>
<a href="/day12_cart/addCartServlet?name=红楼梦">红楼梦</a><br/>
<a href="/day12_cart/addCartServlet?name=水浒传">水浒传</a><br/>
<a href="/day12_cart/addCartServlet?name=西游记">西游记</a><br/>
<a href="/day12_cart/myCartServlet">查看我的购物车</a><br/>
</body>
</html>
