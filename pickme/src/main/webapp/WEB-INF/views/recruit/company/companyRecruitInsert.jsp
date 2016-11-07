<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/typeahead.js/0.11.1/typeahead.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/corejs-typeahead/0.11.1/bloodhound.js"></script>
<script>	 
$(document).ready(function(){

	/************* 기업검색 자동완성 *******************/ 
	var states = new Bloodhound({
		  datumTokenizer: Bloodhound.tokenizers.whitespace,
		  queryTokenizer: Bloodhound.tokenizers.whitespace,
		  // `states`는 The Basics으로 정의된 company 배열의 이름
		  local: states
		});
	var substringMatcher = function(strs) {
		  return function findMatches(q, cb) {
		    var matches, substringRegex;
		    matches = [];
		    // q가 문자열에 있는지 확인 
		    substrRegex = new RegExp(q, 'i');

		   // q를 포함한 문자열을 통해, matches의 배열에 추가
		    $.each(strs, function(i, str) {
		      if (substrRegex.test(str)) {
		        matches.push(str);
		      }
		    });
		    cb(matches);
		  };
		};
		
	//db에서 가져온 기업명 리스트
	var list = new Array();
	<c:forEach items="${companyList}" var="item">
	list.push("${item}");
	</c:forEach>
	var states =  list; 

	$('#the-basics .typeahead').typeahead({
		hint: true,
		highlight: true,
		minLength: 1
	}, {
	  name: 'states',
	  source: substringMatcher(states)
	}).on('typeahead:open', function() {
	}).on('typeahead:rendered', function(element, data) { // 검색 결과 화면 생성 이벤트
	}).on('typeahead:cursorchanged', function(element, data) { // 위 아래 커서 이동시 이벤트
	}).on('typeahead:selected', function(element, data) { // 선택 이벤트
	}).on('typeahead:autocompleted', function(element, data) { // 검색어 자동완성 이벤트
	});

	/************ 직무 대분류 - 중분류 *********** */

	$(document).on("change",".jobTopIndexCd",function(){  
		$('.jobMidIndexCd').empty();
		<c:forEach items="${jobMidIndex}" var ="jobMid">
			if($('.jobTopIndexCd').val()=="${jobMid.jobTopIndexCd}"){
				$('.jobMidIndexCd').append('<option value="${jobMid.jobMidIndexCd}">${jobMid.jobMidIndexName}</option>');
			}
		</c:forEach>	
	});
	
	/************ 직무추가 버튼 클릭  ************/
	var jobDetail = 
			'<div id="job1"><hr/>'+
				'<div class="form-group">'+
				'직무선택 : '+
					'<select name="jobTopIndexCd" class="jobTopIndexCd" >'+
						'<option value="">대분류</option>'+
						'<c:forEach var ="jobTopIndex" items="${jobTopIndex}">'+
							'<option value="${jobTopIndex.jobTopIndexCd}">${jobTopIndex.jobTopIndexName}</option>'+
						'</c:forEach>'+
					'</select>'+							
					'<select name="jobMidIndexCd" class="jobMidIndexCd">'+
					 	'<option value="">소분류</option>'+ 
					'</select>'+
				'</div>'+
				'<div class="form-group">'+
					'채용형태(선택)'+
					'<select name="recruitJobWorkstatus" class="recruitJobWorkstatus">'+
						'<option value="신입">신입</option>'+
						'<option value="경력">경력</option>'+
						'<option value="인턴">인턴</option>'+
						'<option value="계약직">계약직</option>'+
					'</select>'+
				'</div>'+
				'<div class="form-group">'+
					'채용상세직무'+
					'<input type="text" name="recruitJobJobdetail" class="recruitJobJobdetail form-control" >'+
				'</div>'+
				'<div class="form-group">'+
					'학력'+
					'<select name="recruitJobEducation" class="recruitJobEducation form-control" >'+
						'<option value="학력무관">학력무관</option>'+
						'<option value="고졸">고졸</option>'+
						'<option value="전문대졸">전문대졸</option>'+
						'<option value="4년대졸">4년대졸</option>'+
					'</select>'+
				'</div>'+
			'</div>'
	$('#jobAddBtn').click(function(){
		var flag = false;
		 $('.recruitJobJobdetail').each(function(index, item){
            if($(this).val() == ''){
                flag = true;    
        	} 
		 }); 
		 $('.jobMidIndexCd').each(function(index, item){
            if($(this).val() == ''){
                flag = true;    
       		 } 
		 }); 
		 if(flag){
			$('#jobAddError').text('상세직무 모두입력후 추가가능합니다.');
		}else{
			$('#jobDetail').append(jobDetail);
		}
	});
	
	/***********  직무 삭제 버튼***********/ 
		$('#jobRemoveBtn').click(function(){
			 $('#job1').last().remove();
		});
		
	/************ 등록버튼 클릭시 유효성검사 ************/
 	$('#recruitAdd').click(function(){	
		if($('#CompanyName').val()==''){
			$('#error').text('기업명을 입력하세요');
			$('#CompanyName').focus();	
		}else if($('#recruitName').val()==''){
			$('#error').text('공고명을 입력하세요');
			$('#recruitName').focus();
		}else if($('#recruitBegindate').val()==''){
			$('#error').text('채용시작일을 입력하세요');
			$('#recruitBegindate').focus();
		}else if($('#recruitEnddate').val()==''){
			$('#error').text('채용종료일을 입력하세요');
			$('#recruitEnddate').focus();
		}else if($('#recruitJobFile').val()==''){
			$('#error').text('파일을 선택하세요');
			$('#recruitJobFile').focus();
		}else{
			var flag = false;
			 $('.recruitJobJobdetail').each(function(index, item){
	            if($(this).val() == ''){
	            	$('#error').text('직무를 입력하세요');
	                flag = true;    
	        	} 
			 }); 
			 $('.jobMidIndexCd').each(function(index, item){
	            if($(this).val() == ''){
	            	$('#error').text('채용상세직무 입력하세요');
	                flag = true;    
	       		 } 
			 }); 
			 if(flag){
				$('#error').text('상세직무 모두입력후 추가가능합니다.');
			}else{
				$('#recruitInsertForm').submit();
			}
		}
		
	}); 
});
</script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<jsp:include
			page="${pageContext.request.contextPath}/WEB-INF/views/common/module/modHeader.jsp" />
		<form id="recruitInsertForm" action="/recruitInsert"
			class="form-horizontal" method="post" enctype="multipart/form-data">
			<h1>채용입력</h1>
			<div class="form-group" id="the-basics">
				채용기업<input class="typeahead" type="text" class="form-control"
					name="CompanyName" id="CompanyName" placeholder="기업명을 입력하세요"
					value="${recruit.companyName}"> <span style="color: gray">*
					검색내에 없는 기업일시 임시등록됩니다.</span>
			</div>
			<div class="form-group">
				채용공고명<input type="text" name="recruitName" id="recruitName"
					class="form-control" value="${recruit.recruitName}">
			</div>

			<div class="form-group">
				채용시작일<input type="date" name="recruitBegindate"
					id="recruitBegindate" class="form-control"
					value="${recruit.recruitBegindate}">
			</div>

			<div class="form-group">
				채용마감일<input type="date" name="recruitEnddate" id="recruitEnddate"
					class="form-control" value="${recruit.recruitEnddate}">
			</div>

			<div class="form-group">
				공고문(사진파일1장) <input type="file" name="recruitJobFile"
					id="recruitJobFile"> <span style="color: red">${errorMsg}</span>
			</div>

			<!-- 직무등록--하나 기본으로 보이고 추가누를시 추가됨 -->
			<hr />
			<h1>직무별 상세입력</h1>
			<div id="job">
				<div class="form-group">
					직무선택 : <select name="jobTopIndexCd" class="jobTopIndexCd">
						<option value="">대분류</option>
						<c:forEach var="jobTopIndex" items="${jobTopIndex}">
							<option value="${jobTopIndex.jobTopIndexCd}">${jobTopIndex.jobTopIndexName}</option>
						</c:forEach>
					</select> <select name="jobMidIndexCd" class="jobMidIndexCd">
						<option value="">소분류</option>
					</select>
				</div>

				<div class="form-group">
					채용형태(선택) <select name="recruitJobWorkstatus"
						class="recruitJobWorkstatus">
						<option value="신입">신입</option>
						<option value="경력">경력</option>
						<option value="인턴">인턴</option>
						<option value="계약직">계약직</option>
					</select>
				</div>
				<div class="form-group">
					채용상세직무
					<%-- 리스트로 들어가니까 value="${recruit.recruitEnddate}"를 하면 [ㅇㄹㅇ]이런 형식으로 들어간당 --%>
					<input type="text" name="recruitJobJobdetail"
						class="recruitJobJobdetail">
				</div>

				<div class="form-group">
					학력 <select name="recruitJobEducation"
						class="recruitJobEducation form-control">
						<option value="학력무관">학력무관</option>
						<option value="고졸">고졸</option>
						<option value="전문대졸">전문대졸</option>
						<option value="4년대졸">4년대졸</option>
					</select>
				</div>
			</div>

			<div id="jobDetail"></div>

			<hr />
			<div class="form-group">
				<input type="button" id="jobAddBtn" value="직무추가"> 
				 <input type="button"id="jobRemoveBtn" value="직무삭제">
				 <span id="jobAddError" style="color: red"></span>
			</div>

			<div class="form-group">
				<input type="button" id="recruitAdd" value="등록"> 
				<span id="error" style="color: red"></span>
			</div>
		</form>
	</div>
</body>
</html>