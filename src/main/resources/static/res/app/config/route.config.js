(function () {
    'use strict';
    angular.module('unnormal.routing', ['ui.router']);
    angular.module('unnormal.routing').config(
        ['$locationProvider', '$stateProvider',
            function ($locationProvider, $stateProvider) {

                // enable html5Mode for pushstate ('#'-less URLs)
                $locationProvider.html5Mode(true);
                // $urlRouterProvider.otherwise('/');
                $stateProvider.
                    state('home', {
                        url: '/',
                        templateUrl: '/res/app/view/home.html',
                        controller: 'homeController'
                    })
                    .state('page', {
                        url: '/page',
                        templateUrl: 'res/app/view/page.html',
                        controller: 'pageController'
                    })
            }]);

})();