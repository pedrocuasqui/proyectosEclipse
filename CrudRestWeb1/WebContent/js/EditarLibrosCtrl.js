//generalmente se crea un controlador por pantalla
var app= angular.module("moduloAplicacion");
app.controller("editarLibrosCtrl", function($scope,$location, adminLibroSrv){
	var params= $location.search();	
	$scope.params1= params;
	$scope.libro={
			id:5,
			titulo:'softwareLibre',
			autor:'stallman',
			stock:3
	}
//	para enviar un objeto JSON, solo enviar un objeto JSON
	$scope.actualizar= function (){
		console.log('funcion actualizar controlador');
		adminLibroSrv.actualizarLibro($scope.libro,
				function(mensajeExito){
			$scope.mensaje= mensajeExito;
		}, function(mensajeError){
			$scope.mensaje= mensajeError;
		});
		
	}
	
});