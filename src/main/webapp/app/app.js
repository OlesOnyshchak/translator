var module = angular.module('app', [
    'ui.router',
    'ui.bootstrap'
]);
module.config([
    '$stateProvider',
    '$urlRouterProvider',
    function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise('/home');

        $stateProvider
            .state('otherwise', {
                url: '/',
                templateUrl: 'index.html',
                controller: 'HomeController'
            })
            .state('home', {
                url: '/home',
                templateUrl: 'index.html',
                controller: 'HomeController'
            })
    }]);