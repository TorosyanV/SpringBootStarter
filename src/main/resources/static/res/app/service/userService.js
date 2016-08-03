/**
 * Created by vazgen on 3/17/16.
 */
/**
 * Created by Vazgen on 6/26/2015.
 */


(function () {
    "use strict";

    angular.module('unnormal').factory('userService', function ($http, $q) {

        return {

            get: function (userId) {
                var deferred = $q.defer();
                $http({method: "GET", url: "/user/" + userId}).
                success(
                    function (data, status, headers, config) {
                        deferred.resolve(data);
                    }).
                error(function (data, status, headers, config) {
                    deferred.reject(status);
                });
                return deferred.promise;
            },

            create: function (user) {
                var deferred = $q.defer();
                $http({method: "POST", url: "/user/create", data:user}).
                success(
                    function (data, status, headers, config) {
                        deferred.resolve(data);
                    }).
                error(function (data, status, headers, config) {
                    deferred.reject(status);
                });
                return deferred.promise;

            }
        };
    });
})();

