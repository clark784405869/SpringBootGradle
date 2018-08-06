(function(angular) {
  var AppController = function($scope,$http, Item) {
    Item.query(function(response) {
      $scope.items = response ? response : [];
    });
    
    $scope.addItem = function(description) {
      new Item({
        description: description,
        checked: false
      }).$save(function(item) {
        $scope.items.push(item);
      });
      $scope.newItem = "";
    };
    
    $scope.updateItem = function(item) {
      item.$update();
    };
    
    $scope.deleteItem = function(item) {
      item.$remove(function() {
        $scope.items.splice($scope.items.indexOf(item), 1);
      });
    };
    $scope.save=function() { 
    	console.log("fileupload");
        var fd = new FormData();
        var file = document.querySelector('input[type=file]').files[0];
        fd.append('logo', file); 
         $http({
              method:'POST',
              url:"/file/upload",
              data: fd,
              headers: {'Content-Type':undefined},
              transformRequest: angular.identity 
               }).then( function ( response )
                       {
                       //上传成功的操作
                       alert("uplaod success");
                       }, function errorCallback(response) {
                   		// 请求失败执行代码
                       }); 

     }
  };
  
  AppController.$inject = ['$scope', 'Item'];
  angular.module("myApp.controllers").controller("AppController", AppController);
}(angular));