<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>

<script src="/js/index.js"></script>
<link rel="stylesheet"
	href="/lib/Css/index.css">
<div class="box">
		<div class="planDetail">
			<div class="boxTitle">
				<h1>Select Plan</h1>
			</div>
			<div class="boxContent">

				<input type="radio" id="daily" name="price"> <label
					id="dailyPrice" class="price" for="daily">
					<p>Daily</p> <br>
					<p id="dailyPriceRate">10 INR</p>
				</label> <input type="radio" id="monthly" name="price"> <label
					id="monthlyPrice" class="price" for="monthly">
					<p>Monthly</p> <br>
					<p id="monthlyPriceRate">100 INR</p>
				</label> <input type="radio" id="yearly" name="price" checked> <label
					id="yearlyPrice" class="price" for="yearly">
					<p>Yearly</p> <br>
					<p id="yearlyPriceRate">500 INR</p>
				</label> <select id="currencyType" onchange="changeCurrency()">
					<option value="INR" selected>INR</option>
					<option value="USD">USD</option>
					<option value="YEN">YEN</option>
				</select><br>

				<button onclick="calculateMoney()">Next</button>
			</div>
		</div>
		<div class="priceDetail">
			<div class="boxTitle">
				<h1>Payable Amount</h1>
			</div>
			<div class="boxContent">
				<div class="totalPrice">
					<p>Total Amount</p>
					<br>
					<h1 id="priceRate">10 INR</h1>
				</div>
				<button onclick="calculatesMoney('${vehicleType}')">Pay</button>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
changeCurrency('${vehicleType}');
</script>
<%@include file="../includes/footer.jsp" %>

