'use strict';

sbAdminApp.config(function ($stateProvider) {
        $stateProvider
            .state('logout', {
                parent: 'account',
                url: '/logout',
                data: {
                    roles: []
                },
                views: {
                    'content@': {
                        templateUrl: 'views/main/main.html',
                        controller: 'LogoutController'
                    }
                }
            });
    })
    .controller('LogoutController', function (Auth) {
         
        Auth.logout();
    });
