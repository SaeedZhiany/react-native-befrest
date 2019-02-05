using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Befrest.ReactNativeBefrest
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class ReactNativeBefrestModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="ReactNativeBefrestModule"/>.
        /// </summary>
        internal ReactNativeBefrestModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "ReactNativeBefrest";
            }
        }
    }
}
