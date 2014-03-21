TiAlternativeProgressBar
========================

[![Built for Titanium SDK][ti-badge]][ti]
[![Available through gitTio][gittio-badge]][gittio-page]

[ti-badge]: http://www-static.appcelerator.com/badges/titanium-git-badge-sq.png
[ti]: http://www.appcelerator.com/titanium/
[gittio-badge]: http://gitt.io/badge.png
[gittio-page]: http://gitt.io/component/it.smc.alternativeprogressbar

Drop-in replacement for `Ti.UI.ProgressBar`, but with support for **indeterminate mode** and a
**secondary progress**. (Android only)

### Installation

You can install this module using [gitTio][gittio-cli] with

    gittio install it.smc.alternativeprogressbar

Alternatively you can [download a specific release][rls] for manual installation.

[rls]: https://github.com/smclab/TiAlternativeProgressBar/releases
[gittio-cli]: http://gitt.io/cli

### Example

You can run the example running the following command

    gittio demo it.smc.alternativeprogressbar

The source for this demo application can be found in [the `example` folder][exm].

[exm]: https://github.com/smclab/TiAlternativeProgressBar/tree/master/example


Usage
-----

If you want to understand what `secondary` actually means or if you want to see it in action,
in `example/app.js` you’ll find a complete example. The following one only acts as a reference.

```js
var AlternateProgressBar = require('it.smc.alternativeprogressbar');

var progressbar = AlternateProgressBar.createProgressBar({
    min: 0,
    max: 100,
    value: 42,
    secondary: 49,
    indeterminate: true // set to false (default) to show an actual progress
});
```

Credits
-------

Humbly made by the spry ladies and gents at SMC.

License
-------

This library, *TiAlternativeProgressBar*, is free software ("Licensed Software"); you can
redistribute it and/or modify it under the terms of the [GNU Lesser General
Public License](http://www.gnu.org/licenses/lgpl-2.1.html) as published by the
Free Software Foundation; either version 2.1 of the License, or (at your
option) any later version.

This library is distributed in the hope that it will be useful, but WITHOUT ANY
WARRANTY; including but not limited to, the implied warranty of MERCHANTABILITY,
NONINFRINGEMENT, or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General
Public License for more details.

You should have received a copy of the [GNU Lesser General Public
License](http://www.gnu.org/licenses/lgpl-2.1.html) along with this library; if
not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth
Floor, Boston, MA 02110-1301 USA
