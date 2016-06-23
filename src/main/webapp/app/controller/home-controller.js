angular.module('app')
    .controller('HomeController', ['$scope','HomeService', function ($scope,HomeService) {
        $scope.world = "welcome";

        $scope.someTruthyValue = false;

        $scope.someFunction = function() {
            $scope.someTruthyValue = true;
        };

        $scope.get=function(){
            HomeService.getAll().then(function (data) {
                console.log(data);
            });
        };
    }]);
