import { useEffect, useState } from "react"

function useOnline() {
    const [onLine, setOnline] = useState(navigator.onLine)

    useEffect(() => {
        window.addEventListener("online", handleOnline)
        window.addEventListener("offline", handleOffline)
        return () => {
            //OPRYDNING
            window.removeEventListener("online", handleOnline)
            window.removeEventListener("offline", handleOffline)
        }
    }, [])

    const handleOnline = (event) => {
        setOnline(true)
    }
    const handleOffline = (event) => {
        setOnline(false)
    }
    return (
        onLine
    )

}
export default useOnline