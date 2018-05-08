<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
</head>
<body>

	<div id="app">
	
		<div class="section">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						
						<table class="table table-hover table-striped">
							<tbody>
								<tr v-for="user in users" :key="user.id">
									<td>
										<span v-if="user.role == 'ROLE_ADMIN'">
											<a href="#"> <i class="glyphicon glyphicon-eye-open" style="font-size: 25px;"></i> {{ user.id }} </a>
										</span>
										
										<span v-else>
											<a href="#"> <i class="glyphicon glyphicon-eye-close" style="font-size: 25px;"></i> {{ user.id }} </a>
										</span>
									</td>
									
									<td>
										<img src="https://www.jamf.com/jamf-nation/img/default-avatars/generic-user.png" width="60" class="circle">
									</td>
									
									<td>
										<h4>
											<b>
												{{ user.userProfile.firstName }} {{ user.userProfile.lastName }}
											</b>
											{{ user.email }}
										</h4>
									</td>
									
									<td>
									{{ user.userProfile.age }}
									</td>
									
									<td>
										<div class="btn-group">
											<button class="btn btn-danger" type="button" @click="deleteUser(user)">
												<i class="glyphicon glyphicon-erase"></i> Delete
											</button>
										</div>
									</td>
									
								</tr>
							</tbody>
						</table>
						
					</div>
				</div>
			</div>
		</div>
	
	</div>

	<script src="../resources/js/vue.min.js"></script>
	<script src="../resources/js/axios.min.js"></script>
	
	<script>
		
		new Vue({
			
			el: '#app',
			data: {
				rootUrl: 'http://localhost:8080/api',
				users: []
			},
			methods: {
				getUsers(){
					var self = this;
					axios.get(this.rootUrl + "/list/users")
					.then(function(serverResponse){
						//console.log(serverResponse);
						self.users = serverResponse.data; 
					}).catch(function(error){
						console.log(error);
					})
				},
				deleteUser: function(user){
					axios.get(this.rootUrl + "/delete/" + user.id)
						.then(function(resp){
						console.log(resp);
					}).catch(function(error){
						console.log(error);
					})
				}
			},
			mounted(){
				this.getUsers();
			}
		})
	
	</script>
</body>
</html>