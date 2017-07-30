'use strict';

sbAdminApp.factory('Password', function ($resource) {
        return $resource('app/rest/account/change_password', {}, {
        });
    });
