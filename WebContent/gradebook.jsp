<%@page import="customTools.Dataget"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%

	
%> 


<fmt:setLocale value="en_US"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Grade Book</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="mycss.css" />
</head>
<body >

<script language="javascript" type="text/javascript">
function limitText(limitField, limitCount, limitNum) {
	if (limitField.value.length > limitNum) {
		limitField.value = limitField.value.substring(0, limitNum);
	} else {
		limitCount.value = limitNum - limitField.value.length;
	}
}




</script>

<nav class="navbar navbar-default" style="background-color: #01579b">
  <div class="container-fluid ">
    <div class="navbar-header" >
      <a class="navbar-brand " href="login.jsp" style="color: #fff; font-weight: bold;font-size:20px">Bullhorn</a>
    </div>
    <ul class="nav navbar-nav">
     <li><a href="userprofile.jsp" style="color: #fff; font-weight: bold;font-size:20px"><img src= ${ images}  width="20" height="20"></img> ${username}</a></li>
      <li ><a href="home.jsp" style="color: #fff; font-weight: bold;font-size:20px" class="active">Home</a></li>
      <li><a href="newsfeed.jsp" name="allpost" type="button" style="color: #fff; font-weight: bold;font-size:20px">News Feed</a></li>
      <li ><a href="<%=request.getContextPath() %>/logout"  style="color: #fff; font-weight: bold;font-size:20px">Log Out</a></li>
    </ul>
  
  </div>
</nav>


<form action="gradebookServlet"   id="myform" name="myform" >
<div class="container">
<table align="center" border="0" class="table">
<thead>
<tr ><th>Search posts</th></tr>
</thead>
<tbody>
<tr style="backgroundcolor:#4db6ac "><td >Please enter post, at most 141 characters:</td></tr>
<tr>
<td>
<textarea name="limitedtextarea" rows="5" cols="30" onKeyDown="limitText(this.form.limitedtextarea,this.form.countdown,141);" 
onKeyUp="limitText(this.form.limitedtextarea,this.form.countdown,141);">
</textarea>
</td>
</tr>
<tr>
<td><font size="2" >(Maximum characters: 141)<br>
You have <input readonly type="text" name="countdown" size="3" value="141" style="width: 50px; border:none" > characters left.</font><br>
</td>
</tr>
<tr align="center"><td>
<input type="submit" name="method" value="Searchbystudent" class="button"/>
<input type="submit" name="method" value="Searchbyhomework" class="button"/>
<input type="submit" name="method" value="Searchbyquiz" class="button"/>
</td>
</tr>
<tr align="center"><td>
<input type="submit" name="method" value="Searchbytest" class="button"/>
<input type="submit" name="method" value="Searchbyproject" class="button"/>
<input type="submit" name="method" value="Averagebystudent" class="button"/>
</td>
</tr>
<tr align="center"><td>
<input type="submit" name="method" value="Averagebystudenttype" class="button"/>
<input type="submit" name="method" value="highlowbytype" class="button"/>

<input type="submit" name="method" value="Search" class="button"/>
<input type="submit" name="method" value="Show" class="button"/>

</td>
</tr>
</tbody>
</table>
</div>



<div class="container">


<c:if test="false">
    <input type="button" onclick="location.href='gradebook.jsp'" class="button"
            value="Reset List" />
</c:if>
<c:set var="Stu" value="${Students}"/> 
<c:if test="${Stu !=null}">
<input type="submit" name="method" value="Add" class="button"/>

<input type="submit" name="method" value="Insert" class="button" onclick="addRow('gradetable')"/>
<c:if test="true">
    <input type="submit" name="method" value="Save" class="button" />
</c:if>
<input type="submit" name="method" value="Edit" class="button"/>
<input type="submit" name="method" value="Delete" class="button" />

<br /><br />

<table border="1" align="center" id="gradetable" class="table responstable table-bordered table-hover">
<thead align="center">
<tr align="center">
<th align="center"><div align="center">Choose</div></th>
<th align="center"><div align="center">Student ID</div></th>
<th align="center"><div align="center">Assignment Name</div></th>
<th align="center"><div align="center">Type</div></th>
<th align="center"><div align="center">Grade Date</div></th>
<th align="center"><div align="center">Grade</div></th>

</tr>
</thead>
 <tbody>
 
 
 <c:forEach var="student" items="${Students}">
<tr>
	<td  style="width:5%" align="center" >
	<input type="checkbox" name="gradeid" value="${student.gradeid}" 
    <c:if test="${param.gradeid == student.gradeid and param.method != 'Save'}" > checked="checked"</c:if> 
    style="margin: 0 0 0 4px" onclick="radio(this)"></input>
    </td>
    <td align="center">
	<c:choose>
        <c:when test="${param.method == 'Edit' and param.gradeid == student.gradeid}">
            <input type="text" name="studentid" style="padding: 0"
                value="<c:out value="${student.studentid}"/>" />
        </c:when>
        <c:otherwise><c:out value="${student.studentid}"/></c:otherwise>
    </c:choose>
	</td>
    
    <td align="center">
	<c:choose>
        <c:when test="${param.method == 'Edit' and param.gradeid == student.gradeid}">
            <input type="text" name="assignmentname" style="padding: 0"
                value="<c:out value="${student.assignmentname}"/>" />
        </c:when>
        
        <c:otherwise><c:out value="${student.assignmentname}"/></c:otherwise>
    </c:choose>
	</td>
       
    <td align="center"> 
	<c:choose>
        <c:when test="${param.method == 'Edit' and param.gradeid == student.gradeid}">
            <input type="text" name="type" style="padding: 0"
                value="<c:out value="${student.type}"/>" />
        </c:when>
       
        <c:otherwise><c:out value="${student.type}"/></c:otherwise>
    </c:choose>
 	</td> 
    
	<td align="center"> 
	<c:choose>
        <c:when test="${param.method == 'Edit' and param.gradeid == student.gradeid}">
            <input type="text" name="gradedate" style="padding: 0"
                value="<fmt:formatDate pattern="yy-MMM-dd" value="${student.gradedate}" />" />
        </c:when>
        
        <c:otherwise><fmt:formatDate pattern="yy-MMM-dd" value="${student.gradedate}" /></c:otherwise>
    </c:choose>
 	</td> 
	<td align="center">
	<c:choose>
        <c:when test="${param.method == 'Edit' and param.gradeid == student.gradeid}">
            <input type="text" name="grade" style="padding: 0"
                value="<c:out value="${student.grade}"/>" />
        </c:when>
        
        <c:otherwise><c:out value="${student.grade}"/></c:otherwise>
    </c:choose>
	</td>
	
	 
	 </tr>
	  
	 </c:forEach>	 
	 
	 <c:if test="${param.method == 'Insert'}">
	 <tr>
	 <td  style="width:5%" align="center" >
	 <c:choose>
	  <c:when test="${param.method == 'Insert' }">
	<input type="checkbox" name="gradeidd" value=""/>
	</c:when>
	</c:choose>
    </td>
     <td align="center">
	<c:choose>
	  <c:when test="${param.method == 'Insert' }">
            <input type="text" name="insertstudentid" style="padding: 0"
                value="<c:out value=""/>" />
        </c:when>
        </c:choose>
        </td>
        <td align="center">
	<c:choose> 
        <c:when test="${param.method == 'Insert' }">
            <input type="text" name="insertassignmentname" style="padding: 0"
                value="<c:out value=""/>" />
        </c:when>
        
        </c:choose>
        </td>
         <td align="center">
	<c:choose>
         <c:when test="${param.method == 'Insert'}">
            <input type="text" name="inserttype" style="padding: 0"
                value="<c:out value=""/>" />
        </c:when>
        </c:choose>
        </td>
        
       <td align="center">
	<c:choose> 
        <c:when test="${param.method == 'Insert' }">
            <input type="text" name="insertgradedate" style="padding: 0"
                value="<fmt:formatDate pattern="yy-MMM-dd" value="${Date}" />" />
        </c:when>
         </c:choose>
         </td>
         <td align="center">
	<c:choose>   
         <c:when test="${param.method == 'Insert'}">
            <input type="text" name="insertgrade" style="padding: 0"
                value="<c:out value=""/>" />
        </c:when>
        </c:choose>
        </td>
	 </tr>
	 </c:if>
	  </tbody> 
 </table> 
 </c:if>
 
 
 <c:set var="avgbystuu" value="${Averagebystudent}"/> 
<c:if test="${avgbystuu !=null}">
<table border="1" align="center" id="avgbystu" class="table responstable table-bordered table-hover">
<thead align="center">
<tr align="center">
<th align="center"><div align="center">Student ID</div></th>
<th align="center"><div align="center">AVG</div></th>


</tr>
</thead>
 <tbody>
 
 <c:forEach var="avgstu" items="${Averagebystudent}">
<tr>
	<td  style="width:5%" align="center" >
	<c:out value="${avgstu.key}"/>
    </td>
    <td  style="width:5%" align="center" >
	<c:out value="${avgstu.value}"/>
    </td>	 
	 </tr> 
	 </c:forEach>
	  </tbody> 
 </table> 
 </c:if>
 
 <c:set var="avgbystutypee" value="${Averagebystudenttype}"/> 
<c:if test="${avgbystutypee !=null}">
<table border="1" align="center" id="avgbystu" class="table responstable table-bordered table-hover">
<thead align="center">
<tr align="center">
<th align="center"><div align="center">Type</div></th>
<th align="center"><div align="center">AVG</div></th>


</tr>
</thead>
 <tbody>
 
 <c:forEach var="avgstutype" items="${Averagebystudenttype}">
<tr>
	<td  style="width:5%" align="center" >
	<c:out value="${avgstutype.key}"/>
    </td>
    <td  style="width:5%" align="center" >
	<c:out value="${avgstutype.value}"/>
    </td>	 
	 </tr> 
	 </c:forEach>
	  </tbody> 
 </table> 
 </c:if>
 
 
  <c:set var="highlowbytypee" value="${highlowbytype}"/> 
<c:if test="${highlowbytypee !=null}">
<table border="1" align="center" id="avgbystu" class="table responstable table-bordered table-hover">
<thead align="center">
<tr align="center">
<th align="center"><div align="center">Type</div></th>
<th align="center"><div align="center">MAX</div></th>
<th align="center"><div align="center">MIN</div></th>


</tr>
</thead>
 <tbody>
 
 <c:forEach var="highlow" items="${highlowbytype}">
 <c:set var="mykey" value="${highlow.key}"/>
 <c:set var="myvalue" value="${highlowbytype[mykey]}"/> 
 <c:forEach var="mykeyy" items="${myvalue}">
<tr>
	<td  style="width:5%" align="center" >
	<c:out value="${highlow.key}"/>
    </td>
    <td  style="width:5%" align="center" >
	<c:out value="${mykeyy.key}"/>
    </td>
    <td  style="width:5%" align="center" >
	<c:out value="${mykeyy.value}"/>
    </td>		 
	 </tr> 
	 </c:forEach>
	 </c:forEach>
	  </tbody> 
 </table> 
 </c:if>
 

 </div> 
 
</form>

</body>
</html>


