(function () {

    'use strict';
    angular.module('unnormal').controller('pageController',
        ['$scope', '$log', 'userService', function ($scope, $log, userService) {
            $scope.pageName = "Page page angular";
            $scope.user={};
            userService.create({name: 'Vazgen', email: 'vazgen@mail.com'}).then(function () {
                $log.info('success');
                showUserData();
            }, function () {
                $log.error('success');
            });
            function showUserData() {

                userService.get(1).then(function (user) {
                    $scope.user=user;
                    $log.info(user);
                }, function () {
                    $log.error('success');
                })
            }
        }]);
})();