(function () {
    'use strict';

    app.config(function ($stateProvider) {
        $stateProvider.state('login', {
            parent: 'site',
            url: '/login',
            views: {
                'content@': {
                    templateUrl: 'views/login.html',
                    controller: 'LoginController',
                    controllerAs: 'vm'
                }

            }
        });

        $stateProvider.state('dashboard', {
            parent: 'site',
            url: '/dashboard',
            data: {
                roles: []
            },
            views: {
                'content@': {
                    templateUrl: 'views/dashboard.html',
                    controller: 'DashboardCtrl',
                    controllerAs: 'vm'
                }
            }
        });
    })

})();
