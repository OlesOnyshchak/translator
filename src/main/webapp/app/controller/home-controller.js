angular.module('app')
    .controller('HomeController', ['$scope','HomeService', function ($scope,HomeService) {
        $scope.world = "welcome";

        $scope.get=function(){
            HomeService.getAll().then(function (data) {
                console.log(data);
            });
        };
    }]);
