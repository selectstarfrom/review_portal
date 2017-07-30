'use strict';

app.controller('LoginController', function ($rootScope, $scope, $state, Auth, Principal, $location, AuthUserService) {

    Auth.logout();
    $scope.username = "";
    $scope.password = "";
    $scope.user = {};
    $scope.errors = {};

    $scope.rememberMe = true;

    $scope.wrongcredential = false;
    $scope.othererroroccured = false;

    $scope.login = function () {
        Auth.login({
            username: $scope.username,
            password: $scope.password,
            rememberMe: $scope.rememberMe
        }).then(function () {

            $scope.authenticationError = false;
            $rootScope.isLoggedIn = true;


            Principal.identity().then(function (account) {
                $rootScope.userName = account.username;
                $rootScope.userId = account.login;
                $rootScope.isAuthenticated = Principal.isAuthenticated;

                if (Principal.isAuthenticated() && account.roles != null) {

                }

            }, function (error) {
                //console.error(error);
            });

            $state.go('dashboard.home');
        }).catch(function (error) {
            $scope.wrongCredential = false;
            $scope.otherErrorOccured = false;
            if (error.data.status == 401 || error.data.error === "Unauthorized") {
                $scope.wrongCredential = true;
                $scope.otherErrorMessage = $rootScope.otherErrorMessage;
            } else {
                $scope.otherErrorMessage = "Something went wrong.. Please contact support team";
                $scope.otherErrorOccured = true;
            }
            $scope.authenticationError = true;
        });
    };

    $scope.$watch('isLoggedIn', function (newVal) {
        $rootScope.isLoggedIn = newVal;
    });

    $rootScope.$watch('authenticationError', function (newVal) {
        $scope.otherErrorMessage = $rootScope.otherErrorMessage;
        $scope.otherErrorOccured = $rootScope.otherErrorOccured;
    });
});
