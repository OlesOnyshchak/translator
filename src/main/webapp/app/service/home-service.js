angular.module('app')
    .factory("HomeService", ['$http', function HomeServiceFactory($http) {
        return {
            save: function (args) {
                return $http.post('save', args).then(function (response) {
                    return response.data;
                });
            },
            getAll: function () {
                return $http.get('/get').then(function (response) {
                    return response.data;
                });
            },
            update: function (reg, url) {
                return $http.put(url, reg).then(function (response) {
                    return response.data;
                });
            },
            delete: function (id) {
                return $http.delete('delete/' + id).then(function (response) {
                });
            }
        }
    }]);